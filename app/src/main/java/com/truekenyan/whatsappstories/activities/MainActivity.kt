package com.truekenyan.whatsappstories.activities

import android.os.Bundle
import android.os.Environment
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.adapters.TabsAdapter
import com.truekenyan.whatsappstories.fragments.FragmentView
import com.truekenyan.whatsappstories.interfaces.OnStoryClicked
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type
import com.truekenyan.whatsappstories.utilities.Commons
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(), OnStoryClicked {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var tabAdapter: TabsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        tabAdapter = TabsAdapter(supportFragmentManager)

        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)

        viewPager.adapter = tabAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    companion object {
        fun getStories(): List<Story> {
            val parentDirectory = File(Environment.getExternalStorageDirectory().toString() + Commons.STORIES_PATH)
            val list  = mutableListOf<Story>()
            val files = parentDirectory.listFiles()
            files?.let {
                for (file in files){
                    when {
                        file.name.endsWith(".jpg") -> {
                            val story = Story(Type.Photo, file.path)
                            list.add(story)
                        }
                        file.name.endsWith(".gif") -> {
                            val story = Story(Type.Gif, file.path)
                            list.add(story)
                        }
                        file.name.endsWith(".mp4") -> {
                            val story = Story(Type.Video, file.path)
                            list.add(story)
                        }
                    }
                }
            }

            return list
        }
    }

    override fun onSaveButtonClicked(path: String) {

    }

    override fun onViewButtonClicked(path: String) {
        val bundle = Bundle()
        bundle.putString(Commons.PATH, path)
        FragmentView().apply {
            arguments = bundle
        }.show(supportFragmentManager, path)
    }

    override fun onImageClicked(path: String) {

    }
}
