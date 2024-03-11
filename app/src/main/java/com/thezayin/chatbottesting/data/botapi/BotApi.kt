package com.thezayin.chatbottesting.data.botapi

import com.thezayin.chatbottesting.domain.model.Message
import com.thezayin.chatbottesting.utils.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BotApi {
    @GET("/get?bid=180701&key=HNALinzc2atw9sWA&uid=[uid]")
    suspend fun sendMessage(@Query("msg") msg: String): Message
}