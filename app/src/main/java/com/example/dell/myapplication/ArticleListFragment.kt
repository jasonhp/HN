package com.example.dell.myapplication

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dell.myapplication.bean.StoryBean
import com.example.dell.myapplication.story.StoryLoader

import com.example.dell.myapplication.story.StoryResult

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ArticleListFragment.OnListFragmentInteractionListener] interface.
 */
class ArticleListFragment : Fragment() {

    // TODO: Customize parameters
    private var storyResult: StoryResult? = null

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    private var curStoryType: String = constants.STORY_TYPE_NEW

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_articlelist_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyArticleListRecyclerViewAdapter(storyResult?.curStoryArr!!, listener)

            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        storyResult = StoryResult()
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    fun loadStory() {
        var loadedStoryList: MutableList<>
        StoryLoader.loadNewStories(curStoryType,
                { result ->
                    println("rx: next! --Jason")
                    println(result)
                }
        )
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: StoryBean?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                ArticleListFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
