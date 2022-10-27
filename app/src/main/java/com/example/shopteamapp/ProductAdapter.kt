package com.example.shopteamapp

import Beans.Product
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class ProductAdapter(val productList: List<Product>):RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        return ProductViewHolder(layoutInflater.inflate(R.layout.item_product,parent,false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item=productList[position]
        holder.render(item)
        val listViewItem  = productList[position]
        holder.productName.text = listViewItem.name
        holder.bind(productList[position]);
    }

    override fun getItemCount(): Int= productList.size


}