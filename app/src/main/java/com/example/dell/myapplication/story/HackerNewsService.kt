package com.example.dell.myapplication.story

import com.example.dell.myapplication.bean.StoryBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface HackerNewsService {
    companion object {
        //baseUrl
        val API_BASE_URL = "https://hacker-news.firebaseio.com/v0/"
    }

    @GET("topstories.json?print=pretty")
    fun topList(): Observable<Array<Number>>

    @GET("newstories.json?print=pretty")
    fun newList(): Observable<Array<Number>>

    @GET("beststories.json?print=pretty")
    fun bestList(): Observable<Array<Number>>

    @GET("item/{id}.json?print=pretty")
    fun getStory(@Path ("storyId") storyId: Number): Observable<StoryBean>
}