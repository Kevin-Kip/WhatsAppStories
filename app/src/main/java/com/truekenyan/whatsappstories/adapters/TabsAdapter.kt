package com.truekenyan.whatsappstories.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.truekenyan.whatsappstories.utilities.Commons
import com.truekenyan.whatsappstories.fragments.FragmentPhotos
import com.truekenyan.whatsappstories.fragments.FragmentSaved
import com.truekenyan.whatsappstories.fragments.FragmentVideos

class TabsAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FragmentPhotos()
            1 -> FragmentVideos()
            2 -> FragmentSaved()
            else -> {
                FragmentPhotos()
            }
        }
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> (Commons.PHOTOS).toUpperCase()
            1 -> (Commons.VIDEOS).toUpperCase()
            2 -> (Commons.SAVED).toUpperCase()
            else -> {
                ""
            }
        }
    }
}