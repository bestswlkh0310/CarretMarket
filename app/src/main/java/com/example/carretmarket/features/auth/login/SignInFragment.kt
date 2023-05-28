package com.example.carretmarket.features.auth.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>() {
    override val viewModel: SignInViewModel by viewModels()

    override fun observerViewModel() {
        initSignIn()
    }

    private fun initSignIn() {
        mBinding.btnLogin.setOnClickListener {
            viewModel.onClickLogin(requireActivity().applicationContext,
                mBinding.etInpId.text.toString(),
                mBinding.etInpPw.text.toString()
            )
        }
    }
}