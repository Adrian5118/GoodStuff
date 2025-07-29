package com.goodstuff.goodstuff.lib

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.goodstuff.goodstuff.R
import java.text.DecimalFormat

class ProductAdapter (
    private val productList: List<Product>,
    private val onItemClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.productName)
        val image = view.findViewById<ImageView>(R.id.productImage)
        val price = view.findViewById<TextView>(R.id.productPrice)
        val rating = view.findViewById<TextView>(R.id.productRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val decimalFormat = DecimalFormat.getInstance();
        val product = productList[position]
        holder.name.text = product.name
        holder.rating.text = "${R.string.product_rating}: ${product.getRating()}"
        holder.price.text = "Rp. ${decimalFormat.format(product.price - (product.price * product.discount))}.00"

        val options: RequestOptions = RequestOptions()
            .centerCrop()
            .placeholder(R.mipmap.ic_goodstuff_round)
            .error(R.mipmap.ic_goodstuff_round)
        Glide.with(holder.itemView.context)
            .load(product.image)
            .apply(options)
            .into(holder.image)

        if(product.stock <= 0) {
            holder.price.text = "${R.string.product_out_of_stock}"
        }

        if(product.discount > 0.0) {
            holder.price.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.discount_red))
        }

        holder.itemView.setOnClickListener() {
            onItemClick(product)
        }

    }

    override fun getItemCount() = productList.size

}