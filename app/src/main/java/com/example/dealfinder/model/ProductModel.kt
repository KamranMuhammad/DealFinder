package com.example.dealfinder.model

import android.provider.ContactsContract
import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("description")
    var description: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("price")
    var price: String? = null,


)

