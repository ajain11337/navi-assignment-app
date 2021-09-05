package com.navi.assignment.app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.navi.assignment.app.common.Constants
import com.navi.assignment.app.data.GetClosedPRUseCaseImpl
import com.navi.assignment.app.data.GetPRUseCase
import com.navi.assignment.app.domain.GithubService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    private fun getBaseUrl(): String {
        return Constants.BASE_URL
    }

    private fun getTimeOut(): Long {
        return Constants.DEFAULT_TIME_OUT
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        return GsonBuilder()
            .setDateFormat(Constants.DEFAULT_TIME_FORMAT)
            .create()
    }

    @Provides
    @Singleton
    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(getTimeOut(), TimeUnit.SECONDS)
            .readTimeout(getTimeOut(), TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun retrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesGithubService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

    @Provides
    fun providesGetPRUseCase(getPRUseCaseImpl: GetClosedPRUseCaseImpl): GetPRUseCase =
        getPRUseCaseImpl
}