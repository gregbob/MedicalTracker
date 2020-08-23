package com.example.medicaltracker.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao)  {

    fun getUser(userId: Long): LiveData<User> {
        return userDao.getUser(userId)
    }

    suspend fun insertUser(user: User): Long {
        return withContext(Dispatchers.IO) {
            return@withContext userDao.insert(user)
        }
    }
}