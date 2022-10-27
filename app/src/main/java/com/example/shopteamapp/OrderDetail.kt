package com.example.shopteamapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        val txtDateOrderDetail: TextView = findViewById(R.id.txtDateOrderDetail)
        val txtCustomerOrderDetail: TextView = findViewById(R.id.txtCustomerOrderDetail)
        val txtEmployeeOrderDetail: TextView = findViewById(R.id.txtEmployeeOrderDetail)

        val date: String? = intent.getStringExtra("date")
        val customer: String? = intent.getStringExtra("customer")
        val employee: String? = intent.getStringExtra("employee")

        txtDateOrderDetail.text = date
        txtCustomerOrderDetail.text = customer
        txtEmployeeOrderDetail.text = employee

        /* TO-DO*/
        // Get list of products from order
    }
}