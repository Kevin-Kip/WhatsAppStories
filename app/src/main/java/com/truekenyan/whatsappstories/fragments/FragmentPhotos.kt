package com.truekenyan.whatsappstories.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.activities.MainActivity
import com.truekenyan.whatsappstories.adapters.StoryAdapter
import com.truekenyan.whatsappstories.models.Story

class FragmentPhotos: Fragment(){

    private val photos = mutableListOf<Story>()
    private lateinit var photosRecycler: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_photos, container, false)

        photosRecycler = rootView.findViewById(R.id.photos_list)

        for (item in MainActivity.getStories()){
            if (item.type == 0){
                photos.add(item)
            }
        }

        photosRecycler.apply {
            adapter = StoryAdapter(photos, context)
            hasFixedSize()
            itemAnimator = DefaultItemAnimator()
            layoutManager = GridLayoutManager(context, 2)
        }

        return rootView
    }
}