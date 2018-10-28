package com.truekenyan.whatsappstories.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type
import com.truekenyan.whatsappstories.utilities.Commons

class StoryAdapter(private var storyList: List<Story>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    init {
        storyList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): StoryViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent)
        return StoryViewHolder(rootView)
    }

    override fun getItemCount(): Int = storyList.size

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentStory: Story = storyList[holder.adapterPosition]
        holder.bind(storyList[position])

        holder.downloadButton.setOnClickListener(clickListener(Commons.SAVE, currentStory.path))
        holder.viewButton.setOnClickListener(clickListener(Commons.VIEW, currentStory.path))
    }

    private fun clickListener(action: String, path: String): View.OnClickListener {
        return View.OnClickListener {
            if (action == Commons.VIEW) {
                //TODO view
            } else if (action == Commons.SAVE) {
                //TODO save
            }
        }
    }

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val storyImage: ImageView = itemView.findViewById(R.id.status_image)!!
        val downloadButton: ImageView = itemView.findViewById(R.id.button_download)!!
        val viewButton: ImageView = itemView.findViewById(R.id.button_view)!!

        fun bind(story: Story){
            if (story.type == Type.Photo) {
                storyImage.setImageDrawable(Drawable.createFromPath(story.path))
            }
        }
    }
}