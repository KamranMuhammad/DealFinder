package com.example.dealfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dealfinder.adapter.Adapter
import com.example.dealfinder.adapter.AdapterBest
import com.example.dealfinder.modelBestS.BestSeller
import com.example.dealfinder.modelDeals.Deals
import com.example.dealfinder.services.ServiceApi
import com.example.dealfinder.services.ServiceApiBest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BestSellerActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: AdapterBest


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_seller)

        recyclerView = findViewById(R.id.recycler_view1)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        getProducts()
    }

    private fun getProducts() {
        val apiDeal = ServiceApiBest.Api.dealsInstance.getAllData()
        apiDeal.enqueue(object : Callback<BestSeller>{
            override fun onResponse(call: Call<BestSeller>, response: Response<BestSeller>) {
                val newDeal = response.body()
                if (newDeal != null){
                    myAdapter = AdapterBest(this@BestSellerActivity, newDeal.bestsellers)
                    recyclerView.adapter = myAdapter

                }

            }

            override fun onFailure(call: Call<BestSeller>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


}