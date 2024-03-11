package com.thezayin.chatbottesting

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.hilt.navigation.compose.hiltViewModel
import com.thezayin.chatbottesting.domain.model.Message
import com.thezayin.chatbottesting.presentation.ChatScreen
import com.thezayin.chatbottesting.presentation.ChatViewModel
import com.thezayin.chatbottesting.ui.theme.ChatbottestingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatbottestingTheme {
                ChatScreen()
            }
        }
    }
}
