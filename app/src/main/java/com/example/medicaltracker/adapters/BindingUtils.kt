package com.example.medicaltracker.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.medicaltracker.data.Symptom
import java.time.Instant

@BindingAdapter("symptomDateString")
fun TextView.setSymptomDateString(item: Symptom) {
    text = Instant.now().toString()
}