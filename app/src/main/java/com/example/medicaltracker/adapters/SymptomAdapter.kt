package com.example.medicaltracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medicaltracker.R
import com.example.medicaltracker.data.Symptom
import com.example.medicaltracker.utilities.util

class SymptomAdapter : RecyclerView.Adapter<util.TextItemViewHolder>() {

    var data = listOf<Symptom>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: util.TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): util.TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return util.TextItemViewHolder(view)
    }
}