package com.example.dealfinder.model

data class Pagination(
    val current_page: Int,
    val total_deals: Int,
    val total_pages: Int,
    val total_results: Int
)