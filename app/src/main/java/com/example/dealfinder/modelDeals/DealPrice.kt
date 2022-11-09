package com.example.dealfinder.modelDeals

data class DealPrice(
    val currency: String,
    val name: String,
    val raw: String,
    val symbol: String,
    val value: Double
)
