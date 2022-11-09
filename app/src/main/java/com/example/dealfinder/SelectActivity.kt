package com.example.dealfinder

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_select.*
import kotlinx.android.synthetic.main.product_row_item.*

class SelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)

        val button1  = findViewById<Button>(R.id.buttonDeal)
        val button2 = findViewById<Button>(R.id.buttonBest)

        button1.setOnClickListener {
            startActivity(Intent(this,DisplayActivity::class.java))
        }
        button2.setOnClickListener {
            startActivity(Intent(this,BestSellerActivity::class.java))
        }



    }
}