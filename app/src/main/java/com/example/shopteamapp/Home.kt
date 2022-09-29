package com.example.shopteamapp

import Beans.Product
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import Interface.PlaceHolder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var productAdapter: ProductAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var service: PlaceHolder
   // private lateinit var mutableList: MutableList<Product>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        productAdapter = ProductAdapter(mutableListOf())
        val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/LITO-TR/bdShop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolder>(PlaceHolder::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        service.getListProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                val pro=response?.body()
                val listProd= mutableListOf<Product>()
                if(pro!= null){
                    for(item in pro){
                        listProd.add(
                            Product(
                                item._id
                                ,item.name
                                ,item.unitPrice
                                ,item.description
                                ,item.stock
                                ,item.img
                                ,item.campus
                                ,item.__v
                                ,item.category
                            )
                        )
                    }
                }
                val layoutManager = LinearLayoutManager(context)
                recycler=view.findViewById(R.id.recyclerInventory)
                recycler.layoutManager=layoutManager
                recycler.setHasFixedSize(true)
                productAdapter= ProductAdapter(listProd)
                recycler.adapter=productAdapter
            }
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                t?.printStackTrace()
            }
        })


    }


}