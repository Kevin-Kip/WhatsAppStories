package com.truekenyan.whatsappstories.fragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.truekenyan.whatsappstories.R
import com.truekenyan.whatsappstories.utilities.Commons

class FragmentView: DialogFragment() {

    private lateinit var imageView: ImageView

    private lateinit var args: Bundle
    private var imagePath: String? = Commons.PATH

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_view, container, false)
        setStyle(DialogFragment.STYLE_NO_TITLE, 0)

        imageView = rootView.findViewById(R.id.image)

        args = arguments!!

        imagePath = args.getString(Commons.PATH)

        imageView.setImageDrawable(Drawable.createFromPath(imagePath))

        return rootView
    }
}