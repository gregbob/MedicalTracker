package com.example.medicaltracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symptoms")
data class Symptom (
    val name : String,
    val time : String,
    val rating : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Long? = null
}
