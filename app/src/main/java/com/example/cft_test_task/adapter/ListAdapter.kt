package com.example.cft_test_task.adapter

import android.content.ClipData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cft_test_task.MainActivity
import com.example.cft_test_task.R

class listAdapter (private val items: Map<String,String>) : RecyclerView.Adapter<MainActivity.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivity.ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.story_item_layout, parent, false)
        return MainActivity.ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainActivity.ItemViewHolder, position: Int) {
        holder.binView.text = items.get("bin")
        holder.bankNameView.text = items.get("bankName")
    }

    override fun getItemCount() = items.size

}
