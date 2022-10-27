package com.example.shopteamapp
import Beans.Debt
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DebtViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val debtPrice=view.findViewById<TextView>(R.id.txtPrice)
    val debtDate=view.findViewById<TextView>(R.id.txtDate)
    val debtPhoto=view.findViewById<ImageView>(R.id.imgPhoto)

    fun  render(debtModel: Debt) {
        debtPrice.text=debtModel.price
        debtDate.text=debtModel.date
        Picasso.get()
            .load(debtModel.photo)
            .resize(400,400)
            .centerCrop()
            .into(debtPhoto)
    }

}