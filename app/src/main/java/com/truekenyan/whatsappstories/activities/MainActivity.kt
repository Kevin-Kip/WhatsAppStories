package com.truekenyan.whatsappstories.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.adapters.TabsAdapter
import com.truekenyan.whatsappstories.models.Story
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            var list: List<Story> = ArrayList()

        }
    }
}
