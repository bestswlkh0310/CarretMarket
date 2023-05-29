package com.example.carretmarket.features.onboard.signin

import android.os.Bundle
import android.util.Log
import androidx.activity.addCallback
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignInBinding
import com.example.carretmarket.features.onboard.OnBoardActivity
import com.example.carretmarket.features.onboard.signuporin.SignUpOrInFragment
import com.example.carretmarket.util.Constant.TAG

class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>() {
    override val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback { 
            Log.d(TAG, "SignInFragment - onCreate() called")
            requireActivity().supportFragmentManager.commit {
                setCustomAnimations(R.anim.to_left, R.anim.from_left)

                replace(R.id.fl_on_board, SignUpOrInFragment())
            }
        }
    }

    override fun observerViewModel() {}
}