package com.example.shopteamapp

import Beans.Product
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductViewHolder(view: View): RecyclerView.ViewHolder(view) {
    //val productId = view.findViewById<TextView>(R.id.textId)
    val productName= view.findViewById<TextView>(R.id.txtName)
    val productUnitPrice= view.findViewById<TextView>(R.id.txtPrice)
    val productDescription = view.findViewById<TextView>(R.id.txtDescription)
    val productStock= view.findViewById<TextView>(R.id.txtStock)
    val productImg = view.findViewById<ImageView>(R.id.imgProduct)
    //val productCampus= view.findViewById<TextView>(R.id.txtCampus)
    //val product__v=view.findViewById<TextView>(R.id.txt__v)
    //val productCategory= view.findViewById<TextView>(R.id.txtCategory)

    fun render(productModel: Product){
       // productId.text=productModel._id
        productName.text = productModel.name
        productUnitPrice.text="S/" + productModel.unitPrice
        productDescription.text=productModel.description
        productStock.text= "Stock: "+productModel.stock.toString()
        //productImg.text= productModel.img
        Picasso.get()
            .load(productModel.img)
            .resize(500,500)
            .centerCrop()
            .into(productImg)
        // productCampus.text=productModel.campus
        // product__v.text=productModel.__v.toString()
       // productCategory.text=productModel.category

    }
}