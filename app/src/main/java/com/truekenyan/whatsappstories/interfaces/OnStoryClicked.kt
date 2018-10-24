package com.truekenyan.whatsappstories.interfaces

interface OnStoryClicked {
    fun onSaveButtonClicked(path: String)
    fun onViewButtonClicked(path: String)
    fun onImageClicked(path: String)
}