package com.example.medicaltracker.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.medicaltracker.data.User
import com.example.medicaltracker.data.UserDatabase
import com.example.medicaltracker.data.UserRepository
import com.example.medicaltracker.viewmodels.UserProfileViewModelFactory

object  InjectorUtils {

    private fun getUserRepository(context: Context) : UserRepository {
//        UserDatabase.getInstance(context.applicationContext).userDao.insert(User("Greg"))

        return UserRepository(UserDatabase.getInstance(context.applicationContext).userDao)
    }

    fun provideUserProfileViewModelFactory(fragment: Fragment): UserProfileViewModelFactory {
        return UserProfileViewModelFactory(
            getUserRepository(fragment.requireContext()),
            fragment
        )
    }
}