package com.example.shopteamapp
import Beans.Product
import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class DebtViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val view = view


    val debtPrice=view.findViewById<TextView>(R.id.txtPrice)
    val debtDate=view.findViewById<TextView>(R.id.txtDate)
    val debtPhoto=view.findViewById<ImageView>(R.id.imgPhoto)

    fun render(productModel: Product){

        debtPrice.text="Price: S/" + productModel.unitPrice

        Picasso.get()
            .load(productModel.img)
            .resize(500,500)
            .centerCrop()
            .into(debtPhoto)
    }

    fun bind(productModel: Product) {
        view.setOnClickListener(View.OnClickListener {
            val intent= Intent(view.context,ProductDetail::class.java)
            intent.putExtra("name",productModel.name)
            intent.putExtra("imageURL",productModel.img)
            intent.putExtra("description",productModel.description)
            intent.putExtra("stock",productModel.stock.toString())
            intent.putExtra("price",productModel.unitPrice.toString())
            view.context.startActivity(intent)

        })
    }

}