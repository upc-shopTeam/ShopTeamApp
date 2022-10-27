package com.example.shopteamapp

import Beans.Category
import Beans.Product
import Interface.PlaceHolder
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Settings.newInstance] factory method to
 * create an instance of this fragment.
 */
class Balance : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private lateinit var balanceAdapter: BalanceAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var service: PlaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        balanceAdapter= BalanceAdapter(mutableListOf())
        val retrofit = Retrofit.Builder()
            .baseUrl("https://express-shopapi.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create<PlaceHolder>(PlaceHolder::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_balance, container, false)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Settings.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Settings().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        service.getListProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                val listProd= mutableListOf<Product>();

                val pro=response?.body()
                if(pro!= null){
                    for(item in pro){
                        listProd.add(
                            Product(
                                item.name
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

                val layoutManager = LinearLayoutManager(context)
                recycler=view.findViewById(R.id.recyclerBalance)
                recycler.layoutManager=layoutManager
                recycler.setHasFixedSize(true)
                balanceAdapter= BalanceAdapter(listProd)
                recycler.adapter=balanceAdapter

            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                t?.printStackTrace()
            }

        })









    }

}