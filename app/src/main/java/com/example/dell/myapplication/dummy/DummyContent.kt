package com.example.dell.myapplication.dummy

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.logging.SimpleFormatter

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): DummyItem {
        val curTime = Date().toString()
        return DummyItem(
                curTime.reversed(),
                makeTitle(position),
                makeDes(position, curTime.reversed()),
                "Jason Zhang",
                makeDetails(position),
                curTime
        )
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
    data class DummyItem(val id: String, val title: String, val desc: String, val author: String, val content: String, val pubTime: String) {
        var isFaved: Boolean = false
        val pubDate: String

        init {
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
            pubDate = formatter.format(Date(pubTime))
        }
    }
}
