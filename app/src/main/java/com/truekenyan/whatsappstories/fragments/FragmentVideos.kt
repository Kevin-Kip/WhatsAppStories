package com.truekenyan.whatsappstories.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.activities.MainActivity
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type

class FragmentVideos: Fragment(){

    private lateinit var videosRecycler: RecyclerView
    private val videos = mutableListOf<Story>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_videos, container, false)
        videosRecycler = rootView.findViewById(R.id.videos_list)

        videos.clear()

        for (item in MainActivity.getStories()) {
            if (item.type == Type.Video) {
                videos.add(item)
            }
        }

        return rootView
    }
}