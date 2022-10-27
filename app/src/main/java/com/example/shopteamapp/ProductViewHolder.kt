package com.example.shopteamapp

import Beans.Product
import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shopteamapp.databinding.ActivityProductDatailBinding
import com.squareup.picasso.Picasso

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val view = view


    val productName= view.findViewById<TextView>(R.id.txtName)
    val productUnitPrice= view.findViewById<TextView>(R.id.txtPrice)
    val productStock= view.findViewById<TextView>(R.id.txtStock)
    val productImg = view.findViewById<ImageView>(R.id.imgProduct)

    fun render(productModel: Product){
        productName.text = productModel.name
        productUnitPrice.text="Price: S/" + productModel.unitPrice
        productStock.text= "Stock: "+productModel.stock.toString()+" Und."
        Picasso.get()
            .load(productModel.img)
            .resize(500,500)
            .centerCrop()
            .into(productImg)
    }

    fun bind(productModel: Product) {
        view.setOnClickListener(View.OnClickListener {
            val intent=Intent(view.context,ProductDetail::class.java)
            intent.putExtra("name",productModel.name)
            intent.putExtra("imageURL",productModel.img)
            intent.putExtra("description",productModel.description)
            intent.putExtra("stock",productModel.stock.toString())
            intent.putExtra("price",productModel.unitPrice.toString())
            view.context.startActivity(intent)

        })
    }
}


