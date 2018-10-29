package com.truekenyan.whatsappstories.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

    private val adapter = StoryAdapter(photos)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_photos, container, false)

        photosRecycler = rootView.findViewById(R.id.photos_list)
        emptyTextView = rootView.findViewById(R.id.empty_text_view)

        return rootView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        photos.clear()

        for (item in MainActivity.getStories()) {
            if (item.type == Type.Photo) {
                photos.add(item)
            }
        }

        adapter.notifyDataSetChanged()

        if (photos.size == 0) {
            photosRecycler.visibility = View.GONE
            emptyTextView.visibility = View.VISIBLE
        } else {
            photosRecycler.visibility = View.VISIBLE
            emptyTextView.visibility = View.GONE

            photosRecycler.adapter = StoryAdapter(photos)
            photosRecycler.layoutManager = LinearLayoutManager(context)
            photosRecycler.setHasFixedSize(true)

//            photosRecycler.apply {
//                adapter = StoryAdapter(photos)
//                hasFixedSize()
//                layoutManager = if(context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
//                    GridLayoutManager(context, 2)
//                } else {
//                    GridLayoutManager(context, 4)
//                }
////                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            }
        }
    }
}