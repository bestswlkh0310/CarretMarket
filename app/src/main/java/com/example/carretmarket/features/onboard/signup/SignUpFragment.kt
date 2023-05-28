package com.example.carretmarket.features.onboard.signup

import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpBinding

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>() {
    override val viewModel: SignUpViewModel by viewModels()
    override fun observerViewModel() {
        initSignUp()
    }

    private fun initSignUp() {
        mBinding.btnSignup.setOnClickListener {
            viewModel.onSignupClick(requireContext().applicationContext)
        }
    }
}