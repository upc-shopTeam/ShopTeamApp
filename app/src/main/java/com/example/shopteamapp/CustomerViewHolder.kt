package com.example.shopteamapp

import Beans.Customer
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class CustomerViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val customerName= view.findViewById<TextView>(R.id.txtName)
    val customerEmail=view.findViewById<TextView>(R.id.txtEmail)
    val customerPhoneNumber=view.findViewById<TextView>(R.id.txtPhoneNumber)
    val customerPhoto=view.findViewById<ImageView>(R.id.imgPhoto)

    fun render(customerModel: Customer){
        customerName.text=customerModel.name
        customerEmail.text=customerModel.email
        customerPhoneNumber.text=customerModel.phoneNumber
        Picasso.get()
            .load(customerModel.photo)
            .resize(400,400)
            .centerCrop()
            .into(customerPhoto)
    }

}