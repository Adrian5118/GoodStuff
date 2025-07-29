package com.goodstuff.goodstuff.lib

import java.io.Serializable

data class Review(
    val reviewerID: String,
    var rating: Int = 0,
    var text: String = ""
) : Serializable {
}