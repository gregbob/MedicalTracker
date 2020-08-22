package com.example.medicaltracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.medicaltracker.databinding.FragmentUserProfileBinding
import com.example.medicaltracker.utilities.InjectorUtils
import com.example.medicaltracker.viewmodels.UserProfileViewModel

class UserProfileFragment : Fragment() {

    private lateinit var binding : FragmentUserProfileBinding

    private val viewModel: UserProfileViewModel by viewModels {
        InjectorUtils.provideUserProfileViewModelFactory(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.user.observe(viewLifecycleOwner) {
            binding.userGreeting.text = it.name
        }
    }

}