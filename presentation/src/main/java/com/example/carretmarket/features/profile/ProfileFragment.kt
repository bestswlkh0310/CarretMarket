package com.example.carretmarket.features.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {
    override val viewModel: ProfileViewModel by viewModels()
    override fun observerViewModel() {

    }
}