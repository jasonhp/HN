package com.example.dell.myapplication.story

import com.example.dell.myapplication.story.HackerNewsService.Companion.API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object client {
        var retrofit: Retrofit? = null

        fun request(): HackerNewsService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .client(getHttpClient())
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return retrofit!!.create(HackerNewsService::class.java)
        }

        fun getHttpClient(): OkHttpClient {
            var loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS
            var client = OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build()
            return client
        }
    }
}