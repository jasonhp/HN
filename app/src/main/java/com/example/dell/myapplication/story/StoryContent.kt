package com.example.dell.myapplication.story

import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object StoryContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<StoryItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, StoryItem> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createStoryItem(i))
        }
    }

    private fun addItem(item: StoryItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createStoryItem(data: ): StoryItem {
        val curTime = Date().toString()
        return StoryItem()
    }

    private fun makeTitle(position: Int): String = "title for $position"

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    private fun makeDes(position: Int, id: String): String = "Description of Article: $position, with id: $id"

    /**
     * A dummy item representing a piece of content.
     */
    data class StoryItem(val id: Number, val title: String, val commentCount: Number, val author: String, val score: Number, val pubTime: Long, val url: String) {
        val pubDate: String

        init {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
            pubDate = formatter.format(Date(pubTime))
        }
    }
}
