package com.example.dell.myapplication.bean

import java.text.SimpleDateFormat
import java.util.*

class StoryBean {
    var id: Number = 0
    var by: String? = null
    var descendants: Number? = null
    var kids: List<Number>? = null
    var score: Number? = null
    private var time: Long = 0
    var title: String = ""
    var type: String = ""
    var url: String? = null
    var pubDate: String = ""

    fun getAuthor(): String? = by

    fun getCommentCount(): Number? = descendants

    fun setTime(time: Long) {
        this.time = time
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
        pubDate = formatter.format(Date(this.time))
    }

    fun getTime(): Long = time
}