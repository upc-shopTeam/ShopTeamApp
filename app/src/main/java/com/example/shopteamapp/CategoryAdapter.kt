package com.example.shopteamapp

import Beans.Category
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val categoryList: List<Category>):RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var layoutInflater=LayoutInflater.from(parent.context)
        return CategoryViewHolder(layoutInflater.inflate(R.layout.item_category,parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item=categoryList[position]
        holder.render(item)
        holder.bind(categoryList[position])
    }

    override fun getItemCount(): Int= categoryList.size


}