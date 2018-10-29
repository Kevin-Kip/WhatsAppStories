package com.truekenyan.whatsappstories.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.holders.StoryViewHolder
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type

class StoryAdapter(private var storyList: MutableList<Story> , private val context: Context) : RecyclerView.Adapter<StoryViewHolder>() {

    init {
        storyList = mutableListOf()

        storyList.add(Story(Type.Photo, "key"))
        storyList.add(Story(Type.Photo, "key"))
        storyList.add(Story(Type.Photo, "key"))
        storyList.add(Story(Type.Photo, "key"))
        storyList.add(Story(Type.Photo, "key"))
        storyList.add(Story(Type.Photo, "key"))
        storyList.add(Story(Type.Photo, "key"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StoryViewHolder {
        val rootView: View = LayoutInflater.from(context).inflate(R.layout.item_story, parent,false)
        Toast.makeText(context, "adapter in oncreateviewholder has ${storyList.size} items", Toast.LENGTH_SHORT).show()
        return StoryViewHolder(rootView)
    }

    override fun getItemCount(): Int = storyList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(storyList[position])
    }
}