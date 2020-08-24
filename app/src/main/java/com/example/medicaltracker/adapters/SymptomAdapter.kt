package com.example.medicaltracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.medicaltracker.data.Symptom
import com.example.medicaltracker.databinding.SymptomItemViewBinding

class SymptomAdapter : ListAdapter<Symptom, SymptomAdapter.ViewHolder>(SymptomDiffCallback()) {
    class SymptomDiffCallback : DiffUtil.ItemCallback<Symptom>() {
        override fun areItemsTheSame(oldItem: Symptom, newItem: Symptom): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Symptom, newItem: Symptom): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(private val binding: SymptomItemViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Symptom) {
            binding.symptom = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SymptomItemViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}