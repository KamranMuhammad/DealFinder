package com.example.dealfinder.model

data class CurrentPrice(
    val currency: String,
    val name: String,
    val raw: String,
    val symbol: String,
    val value: Double
)