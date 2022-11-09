package com.example.dealfinder.services

import com.example.dealfinder.modelDeals.Deals
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

const val  BASE_URL = "https://api.rainforestapi.com/"

interface ServiceApi {


    @GET("request")
    fun getAllData(@Query("api_key") api_key : String = "6B7E04A8845A41348821708383FF98E2",@Query("type") type: String = "deals", @Query("amazon_domain") amazon_domain : String = "amazon.co.uk"): Call<Deals>


    object Api {

        val dealsInstance: ServiceApi
        private val  client = OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).connectTimeout(60,
            TimeUnit.SECONDS)
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        init {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client
                    .addInterceptor(interceptor)
                    .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            dealsInstance = retrofit.create(ServiceApi::class.java)

        }

    }

}

