package com.example.carretmarket.features.onboard.signuporin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpOrInBinding
import com.example.carretmarket.features.onboard.signup.SignUpFragment
import com.example.carretmarket.util.Constant.TAG

class SignUpOrInFragment : BaseFragment<FragmentSignUpOrInBinding, SignUpOrInViewModel>() {
    override val viewModel: SignUpOrInViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            Log.d(TAG, "12345678 - observerViewModel() called")
            when (event) {
                SignUpOrInViewModel.EVENT_ON_CLICK_SIGN_IN -> {
                    Log.d(TAG, "SignUpOrInFragment signin - observerViewModel() called")
                    findNavController().navigate(R.id.action_signUpOrInFragment_to_signInFragment)
                }

                SignUpOrInViewModel.EVENT_ON_CLICK_SIGN_UP -> {
                    Log.d(TAG, "SignUpOrInFragment signup - observerViewModel() called")
                    findNavController().navigate(R.id.action_signUpOrInFragment_to_signUpFragment)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "SignUpOrInFragment - onCreate() called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "SignUpOrInFragment - onCreateView() called")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "SignUpOrInFragment - onViewCreated() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SignUpOrInFragment - onStart() called")
//        mBinding.btnSignUp.setOnClickListener{
//            findNavController().navigate(R.id.action_signUpOrInFragment_to_signUpFragment)
//        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SignUpOrInFragment - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SignUpOrInFragment - onPause() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "SignUpOrInFragment - onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SignUpOrInFragment - onDestroy() called")
    }


}