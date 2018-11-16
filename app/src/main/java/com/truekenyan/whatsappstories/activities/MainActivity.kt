package com.truekenyan.whatsappstories.activities

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Environment
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.adapters.TabsAdapter
import com.truekenyan.whatsappstories.interfaces.OnStoryClicked
import com.truekenyan.whatsappstories.models.Story
import com.truekenyan.whatsappstories.models.Type
import com.truekenyan.whatsappstories.utilities.Commons
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel

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
        val source = File(path)
        val destination = File(Commons.SAVED_PATH + source.name)
        if (!destination.parentFile.exists())
            destination.parentFile.mkdirs()

        if (!destination.exists())
            destination.createNewFile()

        var sourceChannel: FileChannel? = null
        var destinationChannel: FileChannel? = null

        try {
            sourceChannel = FileInputStream(source).channel
            destinationChannel = FileOutputStream(destination).channel
            destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size())
        } catch (e: IOException){
            Toast.makeText(applicationContext, "Unable to save", Toast.LENGTH_SHORT).show()
            Log.d("Error saving", e.message)
        } finally {
            sourceChannel?.close()

            destinationChannel?.close()
        }
    }

    override fun onViewButtonClicked(path: String) {
        val parent = findViewById<ViewGroup>(R.id.view_parent)
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_view, parent, false)
        dialogView.findViewById<ImageView>(R.id.dialog_image).apply {
            setImageDrawable(Drawable.createFromPath(path))
        }
        val builder = AlertDialog.Builder(this).apply {
            setView(dialogView)
        }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onImageClicked(path: String) {
        onViewButtonClicked(path)
    }
}
