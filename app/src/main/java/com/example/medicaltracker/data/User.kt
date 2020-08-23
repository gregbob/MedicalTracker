package com.example.medicaltracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @ColumnInfo(name = "name")
    val name : String
) {
    @PrimaryKey(autoGenerate = true)
    var userId : Long? = null
}
