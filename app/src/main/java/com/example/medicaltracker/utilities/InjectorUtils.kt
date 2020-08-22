package com.example.medicaltracker.utilities

import androidx.fragment.app.Fragment
import com.example.medicaltracker.data.UserRepository
import com.example.medicaltracker.viewmodels.UserProfileViewModelFactory

object  InjectorUtils {

    private fun getUserRepository() : UserRepository {
        return UserRepository()
    }

    fun provideUserProfileViewModelFactory(fragment: Fragment): UserProfileViewModelFactory {
        return UserProfileViewModelFactory(
            getUserRepository(),
            fragment
        )
    }
}