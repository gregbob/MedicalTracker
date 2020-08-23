package com.example.medicaltracker.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SymptomRepository(private val symptomDatabase: SymptomDatabase) {

    fun getSymptom(id: Long): LiveData<Symptom> {
        return symptomDatabase.symptomDao.getSymptom(id)
    }

    fun getAllSymptoms() : LiveData<List<Symptom>> {
        return symptomDatabase.symptomDao.getAllSymptoms()
    }

    suspend fun insertSymptom(symptom: Symptom) {
        withContext(Dispatchers.IO) {
            symptomDatabase.symptomDao.insert(symptom)
        }
    }

    suspend fun deleteSymptoms() {
        withContext(Dispatchers.IO) {
            symptomDatabase.symptomDao.clearTable()
        }
    }
}