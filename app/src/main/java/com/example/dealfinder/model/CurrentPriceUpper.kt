package com.example.dealfinder.model

data class CurrentPriceUpper(
    val currency: String,
    val raw: String,
    val symbol: String,
    val value: Double
)