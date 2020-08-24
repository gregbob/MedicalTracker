package com.example.medicaltracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medicaltracker.adapters.SymptomAdapter
import com.example.medicaltracker.data.Symptom
import com.example.medicaltracker.databinding.FragmentSymptomListViewBinding
import com.example.medicaltracker.utilities.InjectorUtils
import com.example.medicaltracker.viewmodels.SymptomListViewModel


class SymptomListViewFragment : Fragment() {

    private lateinit var binding: FragmentSymptomListViewBinding
    private val adapter = SymptomAdapter()
    private val viewModel: SymptomListViewModel by viewModels {
        InjectorUtils.provideSymptomListViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSymptomListViewBinding.inflate(inflater, container, false)
        binding.symptomList.adapter = adapter

        binding.submitButton.setOnClickListener {
            viewModel.insertSymptom(Symptom("Name", "Now", 10))
        }

        binding.deleteButton.setOnClickListener {
            viewModel.deleteSymptoms()
        }

        viewModel.symptoms.observe(viewLifecycleOwner) {
            it.let {
                adapter.data = it
            }
        }

        return binding.root
    }

}