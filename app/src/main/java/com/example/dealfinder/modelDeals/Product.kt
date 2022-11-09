package com.example.dealfinder.modelDeals

data class Product(
    var title : String,
    var image : String,
    val link: String,
    var deal_price : DealPrice
)
