package com.example.medicaltracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.medicaltracker.utilities.InjectorUtils
import com.example.medicaltracker.viewmodels.UserProfileViewModel

class UserProfileFragment : Fragment() {


    private val viewModel: UserProfileViewModel by viewModels {
        InjectorUtils.provideUserProfileViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            view.findViewById<TextView>(R.id.user_greeting).text = it.name
        }
    }

}