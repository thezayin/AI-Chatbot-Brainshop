package com.thezayin.chatbottesting.data

import com.thezayin.chatbottesting.data.botapi.BotApi
import com.thezayin.chatbottesting.domain.model.Message
import com.thezayin.chatbottesting.domain.repo.BotRepository
import javax.inject.Inject

class BotRepositoryImpl @Inject constructor(private val botApi: BotApi) : BotRepository {
    override suspend fun sendMessage(string: String): Message {
        return botApi.sendMessage(string)
    }
}