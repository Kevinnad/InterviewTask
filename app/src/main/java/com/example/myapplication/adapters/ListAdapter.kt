package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.ApiListResponse
import com.example.myapplication.model.ResultList
import com.techmah.mapandretrofit.adapters.ListViewHolder


class ListAdapter(private val listener: AdapterClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItem = emptyList<ResultList>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return ListViewHolder(
            (LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)),listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListViewHolder).bind(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun setDataList(listItem : List<ResultList>){
        this.listItem = listItem
        notifyDataSetChanged()
    }
}