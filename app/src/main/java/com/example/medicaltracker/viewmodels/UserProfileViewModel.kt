package com.example.medicaltracker.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.medicaltracker.data.User
import com.example.medicaltracker.data.UserRepository

class UserProfileViewModel (
    userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val userId : String = "1"
//    val userId: String = savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    var user: MutableLiveData<User> = userRepository.getUser(userId)
}

