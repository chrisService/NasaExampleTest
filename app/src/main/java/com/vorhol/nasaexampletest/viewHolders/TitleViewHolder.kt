package com.vorhol.nasaexampletest.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vorhol.nasaexampletest.R

class TitleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(
        title: String
    ){
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_title)
        tvTitle.text = title
    }
}