package com.example.dealfinder.model

data class CurrentPriceLower(
    val currency: String,
    val raw: String,
    val symbol: String,
    val value: Double
)