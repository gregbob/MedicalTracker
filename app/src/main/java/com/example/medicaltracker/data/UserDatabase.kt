package com.example.medicaltracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.medicaltracker.data.User
import com.example.medicaltracker.data.UserDao

class UserDatabase {

    @Database(entities = [User::class], version = 1)
    abstract class UserDatabase : RoomDatabase() {
        abstract fun userDao(): UserDao
    }
}