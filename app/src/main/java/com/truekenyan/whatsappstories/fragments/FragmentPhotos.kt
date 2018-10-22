package com.truekenyan.whatsappstories.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.activities.MainActivity
import com.truekenyan.whatsappstories.adapters.StoryAdapter
import com.truekenyan.whatsappstories.models.Story

class FragmentPhotos: Fragment(){

    private val photos = mutableListOf<Story>()
    private lateinit var photosRecycler: RecyclerView
    private lateinit var emptyTextView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_photos, container, false)

        photosRecycler = rootView.findViewById(R.id.photos_list)
        emptyTextView = rootView.findViewById(R.id.empty_text_view)

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
                layoutManager = GridLayoutManager(context, 2)
            }
        }

        return rootView
    }
}