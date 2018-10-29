package com.truekenyan.whatsappstories.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.activities.MainActivity
import com.truekenyan.whatsappstories.adapters.StoryAdapter
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type

class FragmentPhotos: Fragment() {

    private val photos = mutableListOf<Story>()
    private lateinit var photosRecycler: RecyclerView
    private lateinit var emptyTextView: TextView

    private lateinit var storyAdapter: StoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_photos, container, false)

        photosRecycler = rootView.findViewById(R.id.photos_list)
        emptyTextView = rootView.findViewById(R.id.empty_text_view)

        photos.clear()

        for (item in MainActivity.getStories()) {
            if (item.type == Type.Photo) {
                photos.add(item)
            }
        }

        storyAdapter = StoryAdapter(photos, context as Context)

        photosRecycler.apply {
            adapter = storyAdapter
            layoutManager = if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            } else {
                StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
            }
            hasFixedSize()
        }

        return rootView
    }
}