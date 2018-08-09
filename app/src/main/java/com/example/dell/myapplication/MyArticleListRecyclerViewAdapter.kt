package com.example.dell.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


import com.example.dell.myapplication.ArticleListFragment.OnListFragmentInteractionListener
import com.example.dell.myapplication.bean.StoryBean

/**
 * [RecyclerView.Adapter] that can display a [StoryItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyArticleListRecyclerViewAdapter(
        private val mValues: MutableList<StoryBean>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<MyArticleListRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as StoryBean
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_articlelist_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.titleView?.text = item.title
        holder.authorView?.text = item.getAuthor()

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var titleView: TextView? = null
        var authorView: TextView? = null
        var commentCountView: TextView? = null
        var commentIconView: ImageView? = null
        var scoreView: TextView? = null

        init {

        }
    }
}
