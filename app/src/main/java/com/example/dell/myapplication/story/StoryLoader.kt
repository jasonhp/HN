package com.example.dell.myapplication.story

import android.content.Context
import com.example.dell.myapplication.R
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlin.jvm.internal.Intrinsics

class StoryLoader(context: Context) {

    var topList: MutableList<Number> = mutableListOf()
    var bestList: MutableList<Number> = mutableListOf()
    var newList: MutableList<Number> = mutableListOf()

    private val TYPE_TOP: String = context.getString(R.string.story_type_top);
    private val TYPE_NEW: String = context.getString(R.string.story_type_new);
    private val TYPE_BEST: String = context.getString(R.string.story_type_best);

    fun loadNewStories(type: String, next: (result: StoryResult) -> Unit,
                       error: (th: Throwable) -> Unit, complete: () -> Unit) {
        loadStoryIdList(type).flatMap { resList ->
            var list = getList(type)
            var sliceIndex = 0
            when {
                list.size == 0 -> {
                    sliceIndex = resList.size
                    list.addAll(resList)
                }
                list[0] !== resList[0] -> {
                    for ((index, item) in resList.withIndex()) {
                        if (item == list[0]) {
                            sliceIndex = index
                            break;
                        }
                    }
                    list.addAll(0, resList.slice(IntRange(0, sliceIndex)))
                }
            }

            Observable.fromIterable(list.slice(IntRange(0, sliceIndex)))
        }.flatMap{
            id -> loadStoryById(id)
        }
    }

    fun loadStories(type: String, offset: Int?, length: Int?, next: (result: StoryResult) -> Unit,
                    error: (th: Throwable) -> Unit, complete: () -> Unit) {
        var list = getList(type)
        if (list.size > 0) {

        } else {
            loadStoryIdList(type)
        }
    }

    fun loadStoryIdList(type: String): Observable<Array<Number>> {
        var listObservable: Observable<Array<Number>>? = null
        when(type) {
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

    private fun getList(type: String): MutableList<Number> {
        var list: MutableList<Number> = topList
        when(type) {
            TYPE_TOP -> {
                list = topList
            }
            TYPE_BEST -> {
                list = bestList
            }
            TYPE_NEW -> {
                list = newList
            }
        }
        return list
    }
}