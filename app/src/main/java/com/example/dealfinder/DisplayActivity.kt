package com.example.dealfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dealfinder.adapter.Adapter
import com.example.dealfinder.modelDeals.Deals
import com.example.dealfinder.services.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DisplayActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        recyclerView = findViewById(R.id.recycler_view)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager
        getProducts()
    }

    private fun getProducts() {
        val apiDeal = ServiceApi.Api.dealsInstance.getAllData()
        apiDeal.enqueue(object : Callback<Deals>{
            override fun onResponse(call: Call<Deals>, response: Response<Deals>) {
                val newDeal = response.body()
                if (newDeal != null){
                    myAdapter = Adapter(this@DisplayActivity, newDeal.deals_results)
                    recyclerView.adapter = myAdapter

                }

            }

            override fun onFailure(call: Call<Deals>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


}