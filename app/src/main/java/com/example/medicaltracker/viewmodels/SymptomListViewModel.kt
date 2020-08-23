package com.example.medicaltracker.viewmodels

import androidx.lifecycle.*
import com.example.medicaltracker.data.Symptom
import com.example.medicaltracker.data.SymptomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SymptomListViewModel(val repository: SymptomRepository, handle: SavedStateHandle) :
    ViewModel() {

    val symptoms = repository.getAllSymptoms()

    fun insertSymptom(symptom : Symptom) {
        viewModelScope.launch {
            repository.insertSymptom(symptom)
        }
    }

    fun deleteSymptoms() {
        viewModelScope.launch {
            repository.deleteSymptoms()
        }
    }

}
