package com.goodstuff.goodstuff.gui.activities.ui.storefront

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goodstuff.goodstuff.lib.Product
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class StorefrontViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is storefront Fragment"
    }
    val text: LiveData<String> = _text

    val firestore = Firebase.firestore

    private val _products = MutableLiveData<ArrayList<Product>>().apply {
        value = arrayListOf(
            Product(
                "1",
                "Test",
                "placeholder.jpg",
                "",
                "Test",
                75000.00,
                0.0,
                arrayListOf()
            ),
            Product(
                "2",
                "Test",
                "placeholder.jpg",
                "",
                "Test",
                75000.00,
                0.0,
                arrayListOf()
            ),
            Product(
                "3",
                "Test",
                "placeholder.jpg",
                "",
                "Test",
                75000.00,
                0.0,
                arrayListOf()
            ),
            Product(
                "4",
                "Test",
                "placeholder.jpg",
                "",
                "Test",
                75000.00,
                0.0,
                arrayListOf()
            )
        )
    }

    val products: LiveData<ArrayList<Product>> = _products

    private val _product = MutableLiveData<Product>().apply {
        value = Product(
            "1",
            "Test",
            "placeholder.jpg",
            "",
            "Test",
            75000.00,
            0.0,
            arrayListOf()
        )
    }
    val product: LiveData<Product> = _product
}