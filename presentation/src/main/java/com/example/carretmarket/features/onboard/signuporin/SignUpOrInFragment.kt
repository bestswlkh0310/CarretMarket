package com.example.carretmarket.features.onboard.signuporin

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpOrInBinding

class SignUpOrInFragment : BaseFragment<FragmentSignUpOrInBinding, SignUpOrInViewModel>() {
    override val viewModel: SignUpOrInViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                SignUpOrInViewModel.EVENT_ON_CLICK_SIGN_IN -> findNavController().navigate(R.id.action_signUpOrInFragment_to_signInFragment)
                SignUpOrInViewModel.EVENT_ON_CLICK_SIGN_UP -> findNavController().navigate(R.id.action_signUpOrInFragment_to_signUpFragment)
            }
        }
    }
}