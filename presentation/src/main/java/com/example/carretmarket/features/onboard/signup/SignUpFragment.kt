package com.example.carretmarket.features.onboard.signup

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
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

    lateinit var callback: OnBackPressedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callback = requireActivity().onBackPressedDispatcher.addCallback {
            requireActivity().supportFragmentManager.commit {
                setCustomAnimations(R.anim.to_left, R.anim.from_left)
                replace(R.id.fl_on_board, SignUpOrInFragment())
            }
        }
    }

    override fun onStop() {
        super.onStop()
        callback.remove()
    }

    override fun observerViewModel() {
    }
}