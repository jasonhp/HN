package com.example.dell.myapplication.story

import android.util.Log
import com.example.dell.myapplication.constants
import io.reactivex.Observable

class StoryLoader {

    private object Holder { val INSTANCE = StoryLoader() }

    companion object {
        val instance: StoryLoader by lazy { Holder.INSTANCE }

        private val TYPE_TOP: String = constants.STORY_TYPE_TOP
        private val TYPE_NEW: String = constants.STORY_TYPE_NEW
        private val TYPE_BEST: String = constants.STORY_TYPE_BEST

        fun loadStories(list: List<Number>) {
            Log.d("loading stroies", list.toString())
            Observable.fromIterable(list).flatMap { id ->
                loadStoryById(id)
            }
        }

        fun loadStoryIdList(type: String): Observable<Array<Number>> {
            var listObservable: Observable<Array<Number>>? = null
            when (type) {
                TYPE_TOP -> {
                    listObservable = ApiClient.request().topList()
                }
                TYPE_BEST -> {
                    listObservable = ApiClient.request().bestList()
                }
                TYPE_NEW -> {
                    listObservable = ApiClient.request().newList()
                }
            }
            return listObservable!!
        }

        fun loadStoryById(id: Number) = ApiClient.request().getStory(id)

    }
}