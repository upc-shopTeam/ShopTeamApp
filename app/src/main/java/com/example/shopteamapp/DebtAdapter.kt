package com.example.shopteamapp

import Beans.Product
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DebtAdapter(val productList: List<Product>):RecyclerView.Adapter<DebtViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DebtViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        return DebtViewHolder(layoutInflater.inflate(R.layout.item_debt,parent,false))
    }

    override fun onBindViewHolder(holder: DebtViewHolder, position: Int) {
        val item = productList[position]
        holder.render(item)
    }
    override fun getItemCount(): Int = productList.size
}