package com.goodstuff.goodstuff.lib

import java.io.Serializable

data class Product (
    val id: String,
    var name: String = "",
    var image: String = "",
    var description: String = "",
    var category: String = "",
    var price: Double = 0.0,
    var discount: Double = 0.0,
    var stock: Int = 0,
    var reviews: ArrayList<Review> = arrayListOf()
) : Serializable {
    fun getRating(): Double {
        var returnRating = 0.0;
        for(review in reviews) {
            returnRating += review.rating
        }

        return returnRating
    }
}