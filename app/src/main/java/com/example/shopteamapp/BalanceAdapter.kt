package com.example.shopteamapp
import Beans.Product
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BalanceAdapter (val productList: List<Product>):RecyclerView.Adapter<BalanceViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BalanceViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        return BalanceViewHolder(layoutInflater.inflate(R.layout.item_balance,parent,false))
    }

    override fun onBindViewHolder(holder: BalanceViewHolder, position: Int) {
        val item=productList[position]
        holder.render(item)
            }

    override fun getItemCount(): Int= productList.size


}