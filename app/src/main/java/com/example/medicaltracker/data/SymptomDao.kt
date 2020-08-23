package com.example.medicaltracker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SymptomDao {
    @Insert
    fun insert(symptom: Symptom) : Long

    @Query("SELECT * FROM symptoms ORDER BY id DESC")
    fun getAllSymptoms(): LiveData<List<Symptom>>

    @Query("SELECT * FROM symptoms WHERE id = :id")
    fun getSymptom(id: Long): LiveData<Symptom>

    @Query("DELETE FROM symptoms")
    fun clearTable()
}