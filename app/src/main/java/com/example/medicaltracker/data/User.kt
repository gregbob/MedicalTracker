package com.example.medicaltracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User (
    @PrimaryKey val userId : String,
    val name : String
)
