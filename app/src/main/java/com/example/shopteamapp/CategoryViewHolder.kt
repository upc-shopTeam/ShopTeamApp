package com.example.shopteamapp

import Beans.Category
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoryViewHolder(view: View): RecyclerView.ViewHolder(view) {

    val view = view
    val categoryName= view.findViewById<TextView>(R.id.txtNameCategory)

    val categoryImg = view.findViewById<ImageView>(R.id.imgCategory)

    fun render(categoryModel: Category) {
        categoryName.text = categoryModel.name
        Picasso.get()
            .load(categoryModel.img)
            .resize(500,600)
            .centerCrop()
            .into(categoryImg)
    }
    fun bind(categoryModel: Category){
        view.setOnClickListener(){
            val intent = Intent(view.context,OrderByCategory::class.java)
            intent.putExtra("categoryName",categoryModel.name)
            intent.putExtra("categoryImage",categoryModel.img)
            intent.putExtra("categoryId",categoryModel._id)

            view.context.startActivity(intent)


        }
    }

}
