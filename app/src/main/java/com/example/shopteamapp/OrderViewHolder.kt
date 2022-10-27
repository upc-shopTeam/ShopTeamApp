package com.example.shopteamapp

import Beans.Order
import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderViewHolder (View: View) : RecyclerView.ViewHolder(View) {
    val view = View

    val orderDate = view.findViewById<TextView>(R.id.txtOrderDate)
    val orderCustomer = view.findViewById<TextView>(R.id.txtOrderCustomer)
    val orderEmployee = view.findViewById<TextView>(R.id.txtOrderEmployee)

    fun render(orderModel: Order) {
        orderDate.text = "Date: " + orderModel.date.toString()
        orderCustomer.text = "Customer: " + orderModel.customer
        orderEmployee.text = "Employee: " + orderModel.employee
    }

    fun bind(orderModel: Order) {
        view.setOnClickListener(View.OnClickListener {
            val intent = Intent(view.context, OrderDetail::class.java)
            intent.putExtra("date", orderModel.date)
            intent.putExtra("customer", orderModel.customer)
            intent.putExtra("employee", orderModel.employee)
            view.context.startActivity(intent)
        })
    }
}