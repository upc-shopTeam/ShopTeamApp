package com.example.shopteamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_datail)
        val txtNameDetail:TextView = findViewById(R.id.txtNameDetail)
        val txtDescriptionDetail:TextView = findViewById(R.id.txtDescriptionDetail)
        val imgDetail:ImageView=findViewById(R.id.imgDetail)
        val txtStockDetail: TextView=findViewById(R.id.txtStockDetail)
        val txtPriceDetail: TextView=findViewById(R.id.txtPriceDetail)

        val name: String? = intent.getStringExtra("name")
        val imageUrl: String? = intent.getStringExtra("imageURL")
        val description: String? = intent.getStringExtra("description")
        val stock: String? = intent.getStringExtra("stock")
        val price: String? = intent.getStringExtra("price")

        txtNameDetail.text=name
        txtDescriptionDetail.text =description
        txtStockDetail.text=" ("+stock + " und.)"
        txtPriceDetail.text="S/ "+price+".00"
        Picasso.get()
            .load(imageUrl)
            .resize(500,500)
            .centerCrop()
            .into(imgDetail)
    }
}