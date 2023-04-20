package com.example.cft_test_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_test_task.Api.ApiService
import com.example.cft_test_task.Api.RetrofitInstance
import com.example.cft_test_task.databinding.ActivityMainBinding
import com.google.gson.Gson

import java.lang.Exception

//import java.lang.invoke.MethodHandles.lookup
//var binNumber="11111111"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        val txt = "1"
//        val repo = Repository()

        val retrofit = RetrofitInstance.getInstance()
        val apiInterface = retrofit.create(ApiService::class.java)
        binding.checkButton.setOnClickListener {
            lifecycleScope.launchWhenCreated {
                try {

                    Log.i("1",binding.BinText.text.toString())
                    val response = apiInterface.getCardInfo(binding.BinText.text.toString())
                    Log.i("2",response.headers().toString())
                    Log.i("2",response.body().toString())
                    if (response.isSuccessful()) {
                        val json = Gson().toJson(response.body())
//                        txtData.setText(json)
                        binding.infoView.setText(json)
                        println(json.toString())
                        for (element in json){
                            println(element.toString())
                        }
                    }
                } catch (Ex: Exception) {

                    Ex.localizedMessage?.let { it1 -> Log.e("Error", it1) }
                    println("_____________")
                }
            }
        }

    }
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binView: TextView = itemView.findViewById(R.id.bin)
        val bankNameView: TextView = itemView.findViewById(R.id.bank_name)
    }
}