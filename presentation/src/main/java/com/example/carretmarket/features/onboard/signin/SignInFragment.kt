package com.example.carretmarket.features.onboard.signin

import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignInBinding
import com.example.carretmarket.features.onboard.OnBoardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>() {
    override val viewModel: SignInViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                SignInViewModel.EVENT_ON_CLICK_SIGN_IN -> {
                    (activity as OnBoardActivity).startMainActivity()
                }
            }
        }
    }
}