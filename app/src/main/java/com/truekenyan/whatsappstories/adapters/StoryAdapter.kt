package com.truekenyan.whatsappstories.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.holders.StoryViewHolder
import com.truekenyan.whatsappstories.models.Story

class StoryAdapter(private var storyList: List<Story>) : RecyclerView.Adapter<StoryViewHolder>() {

    init {
        storyList = mutableListOf()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StoryViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent)
        return StoryViewHolder(rootView)
    }

    override fun getItemCount(): Int = storyList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(storyList[position])
    }
}