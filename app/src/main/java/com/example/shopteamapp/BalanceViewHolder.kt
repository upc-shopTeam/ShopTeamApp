package com.example.shopteamapp


import Beans.Product
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class BalanceViewHolder(view : View):RecyclerView.ViewHolder(view) {

    val productName= view.findViewById<TextView>(R.id.txtBDName)
    val productUnitPrice= view.findViewById<TextView>(R.id.txtBDUPrice)



    fun render(productModel: Product){
        productName.text = productModel.name
        productUnitPrice.text="S/" + productModel.unitPrice


    }





}