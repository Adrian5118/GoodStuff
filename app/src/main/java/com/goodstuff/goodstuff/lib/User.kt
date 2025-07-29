package com.goodstuff.goodstuff.lib

data class User (
    val id: String,
    var name: String = "",
    var profilePic: String = "",
    var age: Int = 0,
    var joinDate: String = "",
    var paymentDetails: HashMap<String, String> = hashMapOf(),
    var bookmarkedProducts: ArrayList<String>
) {
}