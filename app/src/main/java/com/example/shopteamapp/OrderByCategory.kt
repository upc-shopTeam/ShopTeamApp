package com.example.shopteamapp

import Beans.Product
import Interface.PlaceHolder
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OrderByCategory : AppCompatActivity() {
    lateinit var service: PlaceHolder
    private lateinit var productAdapter: ProductAdapter
    private lateinit var recycler: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://express-shopapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolder>(PlaceHolder::class.java)


        setContentView(R.layout.activity_order_by_category)
        val imgCategory = findViewById<ImageView>(R.id.OimgCategory)
        val nameCategory = findViewById<TextView>(R.id.OnameCategory)
        val id: String? = intent.getStringExtra("categoryId")
        val name: String? = intent.getStringExtra("categoryName")
        val image: String? = intent.getStringExtra("categoryImage")

        Picasso.get()
            .load(image)
            .resize(500,500)
            .centerCrop()
            .into(imgCategory)
        nameCategory.text=name



        service.getProductByCategory(id.toString()).enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                val listProduct = mutableListOf<Product>();
                val cat = response?.body()
                if(cat!=null){
                    for (item in cat){
                        listProduct.add(
                            Product(item.name
                                ,item.unitPrice
                                ,item.description
                                ,item.stock
                                ,item.img
                                ,item.campus
                                ,item.category
                            )
                        )
                    }
                }
                val layoutManager = GridLayoutManager(applicationContext,2)
                recycler=findViewById(R.id.recyclerOrderProduct)
                recycler.layoutManager=layoutManager
                recycler.setHasFixedSize(true)
                productAdapter= ProductAdapter(listProduct)
                recycler.adapter=productAdapter



            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                t?.printStackTrace()
            }

        })


    }
    fun getProductByCategory(id:String){

    }
}