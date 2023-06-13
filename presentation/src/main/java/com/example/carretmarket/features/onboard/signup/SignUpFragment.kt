package com.example.carretmarket.features.onboard.signup

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>() {
    override val viewModel: SignUpViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                SignUpViewModel.EVENT_ON_CLICK_SIGN_UP -> findNavController().navigate(R.id.action_signUpFragment_to_signUpOrInFragment)
            }
        }
    }
}