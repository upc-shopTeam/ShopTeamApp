package com.example.shopteamapp

import Beans.Customer
import Interface.PlaceHolder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.floatingactionbutton.FloatingActionButton
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
 * Use the [Profile.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    val customerObj=Customer("Elvert","elvert@gmail","97713721","rurur")

    private lateinit var customerAdapter: CustomerAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var service: PlaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        customerAdapter= CustomerAdapter(mutableListOf())
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
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        service.getCustomers().enqueue(object : Callback<List<Customer>>{
            override fun onResponse(
                call: Call<List<Customer>>,
                response: Response<List<Customer>>
            )
            {
                val cus=response?.body()
                val listCust= mutableListOf<Customer>()
                if(cus!=null) {
                    for (item in cus) {
                        listCust.add(
                            Customer(
                           //  item._id
                            item.name
                            ,item.email
                            ,item.phoneNumber
                            ,item.photo

                        )
                    )
                }
                }
                val layoutManager = LinearLayoutManager(context)
                recycler=view.findViewById(R.id.recyclerCustomers)
                recycler.layoutManager=layoutManager
                recycler.setHasFixedSize(true)
                customerAdapter= CustomerAdapter(listCust)
                recycler.adapter=customerAdapter
            }

            override fun onFailure(call: Call<List<Customer>>, t: Throwable) {
                t?.printStackTrace()
            }

        })
        val btnAdd=view.findViewById<FloatingActionButton>(R.id.btnAddCustomer)
        btnAdd.setOnClickListener(){

            service.addCustomer(customerObj).enqueue(object :Callback<Customer>{
                override fun onResponse(call: Call<Customer>, response: Response<Customer>) {
                    val toast: Toast=Toast.makeText(context,"${response.body()}",Toast.LENGTH_LONG);
                    toast.show()
                }

                override fun onFailure(call: Call<Customer>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }

    }
}