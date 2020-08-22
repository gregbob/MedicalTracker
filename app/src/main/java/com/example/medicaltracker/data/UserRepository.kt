package com.example.medicaltracker.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.medicaltracker.data.User

class UserRepository  {

    fun getUser(userId: String): MutableLiveData<User> {
        return MutableLiveData<User>(
            User(userId, "Greg")
        )
    }
}