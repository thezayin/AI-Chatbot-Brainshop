package com.thezayin.chatbottesting.di

import com.thezayin.chatbottesting.data.BotRepositoryImpl
import com.thezayin.chatbottesting.data.botapi.BotApi
import com.thezayin.chatbottesting.domain.repo.BotRepository
import com.thezayin.chatbottesting.domain.usecase.BotUseCase
import com.thezayin.chatbottesting.domain.usecase.MessageUseCases
import com.thezayin.chatbottesting.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideBotApi(): BotApi {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BotApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBotRepository(botApi: BotApi): BotRepository {
        return BotRepositoryImpl(botApi)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: BotRepository) =
        MessageUseCases(botUseCase = BotUseCase(repository))
}