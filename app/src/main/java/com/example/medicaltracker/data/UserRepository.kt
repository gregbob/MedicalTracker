package com.example.medicaltracker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.medicaltracker.data.User

class UserRepository  {

    fun getUser(userId: String): LiveData<User> {
        return MutableLiveData<User>(
            User(userId, "Greg")
        )
    }
}