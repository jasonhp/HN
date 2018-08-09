package com.example.dell.myapplication.story

import com.example.dell.myapplication.bean.StoryBean
import com.example.dell.myapplication.constants

class StoryResult {
    private val TYPE_TOP: String = constants.STORY_TYPE_TOP
    private val TYPE_NEW: String = constants.STORY_TYPE_NEW
    private val TYPE_BEST: String = constants.STORY_TYPE_BEST

    var topIdList: MutableList<Number> = mutableListOf()
    var bestIdList: MutableList<Number> = mutableListOf()
    var newIdList: MutableList<Number> = mutableListOf()

    var topStoryArr: MutableList<StoryBean>? = null
    var bestStoryArr: MutableList<StoryBean>? = null
    var newStoryArr: MutableList<StoryBean>? = null

    var curStoryArr: MutableList<StoryBean>? = null

    fun switchStoryList(type: String) {
        when (type) {
            TYPE_TOP -> {
                curStoryArr = topStoryArr
            }
            TYPE_BEST -> {
                curStoryArr = bestStoryArr
            }
            TYPE_NEW -> {
                curStoryArr = newStoryArr
            }
        }
    }

    private fun getIdList(type: String): MutableList<Number> {
        var list: MutableList<Number> = topIdList
        when (type) {
            TYPE_TOP -> {
                list = topIdList
            }
            TYPE_BEST -> {
                list = bestIdList
            }
            TYPE_NEW -> {
                list = newIdList
            }
        }
        return list
    }

    fun setIdList(type: String, list: List<Number>) {
        var idList = getIdList(type)
        var sliceIndex = 0
        when {
            list.size == 0 -> {
                sliceIndex = list.size
                idList.addAll(list)
            }
            idList[0] !== list[0] -> {
                for ((index, item) in list.withIndex()) {
                    if (item == idList[0]) {
                        sliceIndex = index
                        break;
                    }
                }
                idList.addAll(0, list.slice(IntRange(0, sliceIndex)))
            }
        }
    }

    fun modifyStoryList(storyArr: MutableList<StoryBean>, isAppend: Boolean) {
        if (isAppend) {
            storyArr.addAll(storyArr)
        } else {
            storyArr.addAll(0, storyArr)
        }
    }

    fun clearList() {
        curStoryArr?.clear()
    }

    fun getStoryByIndex(idx: Int): StoryBean? {
        return curStoryArr!![idx]
    }
}
