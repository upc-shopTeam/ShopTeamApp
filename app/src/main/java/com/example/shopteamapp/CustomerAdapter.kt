package com.example.shopteamapp

import Beans.Customer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomerAdapter(val customerList: List<Customer>):RecyclerView.Adapter<CustomerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        return CustomerViewHolder(layoutInflater.inflate(R.layout.item_customer,parent,false))
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val item = customerList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = customerList.size

}