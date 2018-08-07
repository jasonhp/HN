package com.example.dell.myapplication.story

import java.text.SimpleDateFormat
import java.util.*

class StoryResult() {
    var count: Int = 0
    var start: Number = 0
    var end: Number = 0
    var storyArr: MutableList<StoryItem>? = null
    var storyMap: MutableMap<Number, StoryItem>? = null

    fun modifyStoryList(storyArr: MutableList<StoryItem>, isAppend: Boolean) {
        if (isAppend) {
            storyArr.addAll(storyArr)
        } else {

        }
    }

    fun getStoryById(id: Number): StoryItem? {
        return storyMap!![id]
    }

    fun getStoryByIndex(idx: Int): StoryItem? {
        return storyArr!![idx]
    }

    /**
     * A story item representing a piece of content.
     */
    data class StoryItem(val id: Number, val title: String, val commentCount: Number, val author: String, val score: Number, val pubTime: Long, val url: String) {
        val pubDate: String

        init {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
            pubDate = formatter.format(Date(pubTime))
        }
    }
}
