package com.example.medicaltracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medicaltracker.R
import com.example.medicaltracker.data.Symptom

class SymptomAdapter : RecyclerView.Adapter<SymptomAdapter.ViewHolder>() {
    var data = listOf<Symptom>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val symptomName: TextView = itemView.findViewById(R.id.symptom_name)
        val symptomTime: TextView = itemView.findViewById(R.id.symptom_date)
//        val symptomStrength: TextView = itemView.findViewById(R.id.symptom_strength)

        fun bind(item: Symptom) {
            symptomName.text = item.name
            symptomTime.text = item.time
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.symptom_item_view, parent, false)
                return ViewHolder(view)
            }
        }
    }

}