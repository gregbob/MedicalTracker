package com.example.medicaltracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.medicaltracker.data.Symptom
import com.example.medicaltracker.utilities.InjectorUtils
import com.example.medicaltracker.viewmodels.SymptomListViewModel


class SymptomListViewFragment : Fragment() {

    private val viewModel: SymptomListViewModel by viewModels {
        InjectorUtils.provideSymptomListViewModelFactory(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.symptoms.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.symptom_text).text = it.toString()
        }

        view.findViewById<Button>(R.id.submit_button).setOnClickListener {
            viewModel.insertSymptom(
                Symptom("Name", "Now", 10)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_symptom_list_view, container, false)
    }

}