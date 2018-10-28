package com.truekenyan.whatsappstories.models

import java.io.Serializable

data class Story(var type: Enum<Type> , var path: String) : Serializable