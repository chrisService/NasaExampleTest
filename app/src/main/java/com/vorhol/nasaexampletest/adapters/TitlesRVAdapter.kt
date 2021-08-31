package com.vorhol.nasaexampletest.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vorhol.nasaexampletest.R
import com.vorhol.nasaexampletest.viewHolders.TitleViewHolder

class TitlesRVAdapter(private val items: MutableList<String>): RecyclerView.Adapter<TitleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vh_item, parent, false)
        return TitleViewHolder(view)
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {

        val item = items[position]

        holder.bind(item)
    }

    override fun getItemCount(): Int {
       return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(data: List<String>){
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }
}