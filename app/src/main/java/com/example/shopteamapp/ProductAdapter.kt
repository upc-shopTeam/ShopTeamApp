package com.example.shopteamapp

import Beans.Product
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(val productList: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item=productList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int= productList.size

}