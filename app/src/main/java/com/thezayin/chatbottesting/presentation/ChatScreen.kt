package com.thezayin.chatbottesting.presentation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.thezayin.chatbottesting.R
import com.thezayin.chatbottesting.presentation.component.ChatBox
import com.thezayin.chatbottesting.presentation.component.MessageBody
import com.thezayin.chatbottesting.presentation.component.TopBar

@OptIn(ExperimentalComposeUiApi::class)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ChatScreen() {

    val chatViewModel: ChatViewModel = hiltViewModel()
    val listState = rememberLazyListState()

    Scaffold(modifier = Modifier
        .fillMaxSize(),
        containerColor = colorResource(id = R.color.white),
        topBar = {
            TopBar(modifier = Modifier, title = "Chat Bot") {}
        },
        bottomBar = {
            ChatBox(
                modifier = Modifier,
                chatViewModel = chatViewModel,
                listState = listState
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = colorResource(id = R.color.white))
                .padding(padding),
            contentPadding = PaddingValues(),
            state = listState
        ) {
            items(chatViewModel._messageState.size) { message ->
                MessageBody(message = chatViewModel._messageState[message])
            }
        }

    }
}
