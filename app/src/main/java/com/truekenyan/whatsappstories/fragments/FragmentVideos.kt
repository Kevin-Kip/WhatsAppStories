package com.truekenyan.whatsappstories.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.activities.MainActivity
import com.truekenyan.whatsappstories.adapters.StoryAdapter
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type

class FragmentVideos: Fragment(){

    private lateinit var videosRecycler: RecyclerView
    private val videos = mutableListOf<Story>()

    private lateinit var storyAdapter: StoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_videos, container, false)
        videosRecycler = rootView.findViewById(R.id.videos_list)

        videos.clear()

        for (item in MainActivity.getStories()) {
            if (item.type == Type.Video) {
                videos.add(item)
            }
        }

        storyAdapter = StoryAdapter(videos, context as Context)
        videosRecycler.apply {
            adapter = storyAdapter
            itemAnimator = DefaultItemAnimator()
            layoutManager = if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            } else {
                StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
            }
            hasFixedSize()
        }

        return rootView
    }
}