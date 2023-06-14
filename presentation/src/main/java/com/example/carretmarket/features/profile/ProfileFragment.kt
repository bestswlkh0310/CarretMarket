package com.example.carretmarket.features.profile

import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val viewModel: ProfileViewModel by viewModels()
    override fun observerViewModel() {

    }
}