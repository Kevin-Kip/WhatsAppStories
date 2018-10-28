package com.truekenyan.whatsappstories.fragments

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.activities.MainActivity
import com.truekenyan.whatsappstories.adapters.PhotosAdapter
import com.truekenyan.whatsappstories.adapters.StoryAdapter
import com.truekenyan.whatsappstories.interfaces.OnStoryClicked
import com.truekenyan.whatsappstories.models.Story

class FragmentPhotos: Fragment(){

    private val photos = mutableListOf<Story>()
    private lateinit var photosRecycler: RecyclerView
    private lateinit var emptyTextView: TextView

    private lateinit var listener: OnStoryClicked

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_photos, container, false)

        photosRecycler = rootView.findViewById(R.id.photos_list)
        emptyTextView = rootView.findViewById(R.id.empty_text_view)

        photos.clear()

        for (item in MainActivity.getStories()){
            if (item.type == 0){
                photos.add(item)
            }
        }

        if (photos.size == 0){
            photosRecycler.visibility = View.GONE
            emptyTextView.visibility = View.VISIBLE
        } else {
            photosRecycler.visibility = View.VISIBLE
            emptyTextView.visibility = View.GONE

            photosRecycler.apply {
                adapter = StoryAdapter(photos, context)
                hasFixedSize()
                itemAnimator = DefaultItemAnimator()
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            }
        }

        return rootView
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnStoryClicked
    }
}