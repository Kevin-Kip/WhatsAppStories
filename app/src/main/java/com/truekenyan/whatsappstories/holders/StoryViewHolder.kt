package com.truekenyan.whatsappstories.holders

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.interfaces.OnStoryClicked
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type
import com.truekenyan.whatsappstories.utilities.Commons

class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val storyImage: ImageView = itemView.findViewById(R.id.status_image)!!
    private val downloadButton: ImageView = itemView.findViewById(R.id.button_download)!!
    private val viewButton: ImageView = itemView.findViewById(R.id.button_view)!!
    private val listener = itemView.context as OnStoryClicked

    fun bind(story: Story){
        if (story.type == Type.Photo) {
            storyImage.setImageDrawable(Drawable.createFromPath(story.path))
        }

        storyImage.setOnClickListener(clickListener(Commons.VIEW, story.path))
        downloadButton.setOnClickListener(clickListener(Commons.SAVE, story.path))
        viewButton.setOnClickListener(clickListener(Commons.VIEW, story.path))
    }

    private fun clickListener(action: String, path: String): View.OnClickListener {
        return View.OnClickListener {
            when (action) {
                Commons.VIEW -> listener.onViewButtonClicked(path)
                Commons.SAVE -> listener.onSaveButtonClicked(path)
            }
        }
    }
}