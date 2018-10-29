package com.truekenyan.whatsappstories.fragments

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.truekenyan.whatsappstories.R

class FragmentView: DialogFragment() {

    private lateinit var imageView: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_view, container, false)
        setStyle(DialogFragment.STYLE_NO_TITLE, 0)
        return rootView
    }
}