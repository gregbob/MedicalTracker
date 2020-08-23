package com.example.medicaltracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.medicaltracker.data.Symptom
import com.example.medicaltracker.data.SymptomRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SymptomListViewModel(val repository: SymptomRepository, handle: SavedStateHandle) :
    ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val symptoms: LiveData<List<Symptom>> = repository.getAllSymptoms()

    fun insertSymptom(symptom : Symptom) {
        uiScope.launch {
            repository.insertSymptom(symptom)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
