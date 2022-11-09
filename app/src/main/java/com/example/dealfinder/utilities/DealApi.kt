package com.example.dealfinder.utilities

import com.example.dealfinder.model.DealsResult
import com.example.dealfinder.model.ProductModel
import com.example.dealfinder.model.ProductModel2
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface DealApi {

    @Headers("Authorization: DAAA50FF305347DDBD57546701CBC90B",
             "asin: B073JYC4XM",
             "type: deals",
             "amazon_domain: amazon.co.uk")
    @GET("request")
    fun getProduct() : Call<List<DealsResult>>


}