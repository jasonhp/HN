package com.example.dell.myapplication.story

import com.example.dell.myapplication.story.HackerNewsService.Companion.API_BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun request(): HackerNewsService {
        var retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        return retrofit.create(HackerNewsService::class.java)
    }
}