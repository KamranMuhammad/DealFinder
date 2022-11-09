package com.example.dealfinder.model

data class ProductModel3(
    val categories: List<Category>,
    val deals_results: List<DealsResult>,
    val pagination: Pagination,
    val request_info: RequestInfoX,
    val request_metadata: RequestMetadataX,
    val request_parameters: RequestParametersX
)