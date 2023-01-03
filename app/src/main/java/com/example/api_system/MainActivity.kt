package com.example.api_system

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_View)

        val serviceGenerator = ServiceGenerator.buildService(API_Interface::class.java)
        val call = serviceGenerator.getData()

        call.enqueue(object : Callback<MutableList<Product>>{
            override fun onResponse(
                call: Call<MutableList<Product>>,
                response: Response<MutableList<Product>>
            ) {
                if (response.isSuccessful){
                    recyclerView.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = RecyclerAdapter(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Product>>, t: Throwable) {
                t.printStackTrace()
                Log.e("error", t.message.toString())
            }

        })


    }


}