package com.example.medicaltracker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Symptom::class], version = 1, exportSchema = false)
abstract  class SymptomDatabase : RoomDatabase() {
    abstract val symptomDao : SymptomDao

    companion object {

        @Volatile
        private var INSTANCE: SymptomDatabase? = null

        fun getInstance(context: Context): SymptomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SymptomDatabase::class.java,
                        "symptoms"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}
