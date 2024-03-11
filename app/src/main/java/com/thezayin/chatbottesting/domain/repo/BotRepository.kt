package com.thezayin.chatbottesting.domain.repo

import com.thezayin.chatbottesting.domain.model.Message
import com.thezayin.chatbottesting.utils.Response
import kotlinx.coroutines.flow.Flow

interface BotRepository {
    suspend fun sendMessage(string: String): Message
}