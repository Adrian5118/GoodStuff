package com.goodstuff.goodstuff.lib

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goodstuff.goodstuff.R

class ReviewAdapter (
    private val reviewList: List<Review>,
    private val onItemClick: (Review) -> Unit
) {
    inner class ReviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val reviewerName = view.findViewById<TextView>(R.id.reviewerName);
        val reviewerProfilePic = view.findViewById<ImageView>(R.id.reviewerProfilePic);
        val reviewRating = view.findViewById<TextView>(R.id.reviewRating);
        val reviewText = view.findViewById<TextView>(R.id.reviewText);
    }
}