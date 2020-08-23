package com.example.medicaltracker.viewmodels

import androidx.lifecycle.*
import com.example.medicaltracker.data.User
import com.example.medicaltracker.data.UserRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

class UserProfileViewModel (
    val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    //    val userId: String = savedStateHandle["uid"] ?: throw IllegalArgumentException("missing user id")
    var userId : Long = -1L
    val user: LiveData<User> = userRepository.getUser(userId)
    val userName = Transformations.map(user) { u -> u?.name }

//    fun insertUser(name: String) {
//        userId = userRepository.insertUser(User(name))
//    }

}

