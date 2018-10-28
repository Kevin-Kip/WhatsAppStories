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

class PhotosAdapter(private var photos: List<Story>, private var context: Context): RecyclerView.Adapter<PhotosAdapter.PhotosHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): PhotosHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.item_story, parent)
        return PhotosHolder(rootView)
    }

    override fun getItemCount(): Int = photos.size

    override fun onBindViewHolder(holder: PhotosHolder, position: Int) {
        val currentStory:Story = photos[position]
        holder.storyImage.setImageDrawable(Drawable.createFromPath(currentStory.path))
    }

    class PhotosHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val storyImage = itemView.findViewById<ImageView>(R.id.status_image)!!
        val downloadButton = itemView.findViewById<ImageView>(R.id.button_download)!!
        val viewButton = itemView.findViewById<ImageView>(R.id.button_view)!!
    }
}