package com.example.medicaltracker.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.medicaltracker.data.*
import com.example.medicaltracker.viewmodels.SymptomListViewModelFactory
import com.example.medicaltracker.viewmodels.UserProfileViewModelFactory

object  InjectorUtils {

    private fun getUserRepository(context: Context) : UserRepository {
        return UserRepository(UserDatabase.getInstance(context.applicationContext).userDao)
    }

    private fun getSymptomRepository(context: Context) : SymptomRepository {
        return SymptomRepository(SymptomDatabase.getInstance(context.applicationContext))
    }

    fun provideUserProfileViewModelFactory(fragment: Fragment): UserProfileViewModelFactory {
        return UserProfileViewModelFactory(
            getUserRepository(fragment.requireContext()),
            fragment
        )
    }

    fun provideSymptomListViewModelFactory(fragment: Fragment): SymptomListViewModelFactory {
        return SymptomListViewModelFactory(getSymptomRepository(fragment.requireContext()), fragment)
    }
}