package com.truekenyan.whatsappstories.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.models.Story

class StoryAdapter(private var storyList: List<Story>, private var context: Context) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    init {
        storyList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StoryViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_story, parent)
        return StoryViewHolder(rootView)
    }

    override fun getItemCount(): Int = storyList.size

    fun setStories(list: List<Story>){
        storyList = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: StoryViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}