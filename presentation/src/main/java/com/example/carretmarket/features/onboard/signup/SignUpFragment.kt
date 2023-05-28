package com.example.carretmarket.features.onboard.signup

import android.os.Bundle
import android.util.Log
import androidx.activity.addCallback
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpBinding
import com.example.carretmarket.features.onboard.signuporin.SignUpOrInFragment
import com.example.carretmarket.util.Constant

class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>() {
    override val viewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback {
            Log.d(Constant.TAG, "SignUpFragment - onCreate() called")
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fl_on_board, SignUpOrInFragment())
            }
        }
    }

    override fun observerViewModel() {
    }
}