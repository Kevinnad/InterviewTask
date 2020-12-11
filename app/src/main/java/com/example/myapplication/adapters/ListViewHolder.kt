package com.techmah.mapandretrofit.adapters

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.adapters.AdapterClickListener
import com.example.myapplication.model.ApiListResponse
import com.example.myapplication.model.ResultList
import kotlinx.android.synthetic.main.list_item.view.*

class ListViewHolder(
    itemView: View,
    private val listener: AdapterClickListener,
    val context: Context
) : RecyclerView.ViewHolder(itemView) {

    fun bind(apiListResponse: ResultList) {

        itemView.tv_name.text = apiListResponse.abstract
        itemView.user_lay.setOnClickListener {
            listener.onItemClick(adapterPosition, "")
        }
        itemView.tv_node_id.text = apiListResponse.byline
        itemView.tv_type.text = apiListResponse.publishedDate
    }

}