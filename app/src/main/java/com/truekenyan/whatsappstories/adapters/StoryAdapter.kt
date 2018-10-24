package com.truekenyan.whatsappstories.adapters

import android.content.Context
import android.media.ThumbnailUtils
import android.provider.MediaStore
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
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

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentStory: Story = storyList.get(holder.adapterPosition)
        when (currentStory.type){
            0 -> {
                Picasso.get().load(currentStory.path)
            }
            1 -> 1
            2 -> {
                val bitmap = ThumbnailUtils.createVideoThumbnail(currentStory.path, MediaStore.Video.Thumbnails.MICRO_KIND)
            }
            else -> {
                8
            }
        }
    }

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}