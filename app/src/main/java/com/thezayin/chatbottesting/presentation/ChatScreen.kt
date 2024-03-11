package com.thezayin.chatbottesting.presentation

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.thezayin.chatbottesting.presentation.component.ChatBox
import com.thezayin.chatbottesting.presentation.component.MessageBody
import com.thezayin.chatbottesting.presentation.component.TopBar

@OptIn(ExperimentalComposeUiApi::class)
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@Composable
fun ChatScreen() {

    val chatViewModel: ChatViewModel = hiltViewModel()
    val listState = rememberLazyListState()

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TopBar(title = "Chat Bot") {}

            LazyColumn(modifier = Modifier.fillMaxWidth(), state = listState) {
                items(chatViewModel._messageState.size) { message ->
                    MessageBody(message = chatViewModel._messageState[message])
                }
            }
            ChatBox(chatViewModel = chatViewModel, listState = listState)
        }
    }
}