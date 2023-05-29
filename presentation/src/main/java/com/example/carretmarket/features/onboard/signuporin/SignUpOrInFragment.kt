package com.example.carretmarket.features.onboard.signuporin

import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpOrInBinding
import com.example.carretmarket.features.onboard.signin.SignInFragment
import com.example.carretmarket.features.onboard.signup.SignUpFragment

class SignUpOrInFragment : BaseFragment<FragmentSignUpOrInBinding, SignUpOrInViewModel>() {
    override val viewModel: SignUpOrInViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                SignUpOrInViewModel.EVENT_ON_CLICK_SIGN_IN -> requireActivity().supportFragmentManager.commit {
                    setCustomAnimations(R.anim.to_right, R.anim.from_right)

                    replace(R.id.fl_on_board, SignInFragment())
                }
                SignUpOrInViewModel.EVENT_ON_CLICK_SIGN_UP -> requireActivity().supportFragmentManager.commit {
                    setCustomAnimations(R.anim.to_right, R.anim.from_right)

                    replace(R.id.fl_on_board, SignUpFragment())
                }
            }
        }
    }
}