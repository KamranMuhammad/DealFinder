package com.example.dealfinder.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dealfinder.R
import com.example.dealfinder.modelBestS.BestSeller
import com.example.dealfinder.modelBestS.BestSellerProducts


class AdapterBest(private val context: Context, private val products : List<BestSellerProducts> ) : RecyclerView.Adapter<AdapterBest.MyViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_best_seller_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val deal = products[position]
        holder.title.text = deal.title
        holder.price.text = deal.price.toString()

        Glide.with(context).load(deal.image).centerCrop().into(holder.imageView)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val title = itemView.findViewById<TextView>(R.id.product_title)
        val imageView = itemView.findViewById<ImageView>(R.id.product_image)
        val price =  itemView.findViewById<TextView>(R.id.product_price)

    }



}