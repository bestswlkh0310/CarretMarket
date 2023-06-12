package com.example.carretmarket.features.onboard.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignUpBinding
import com.example.carretmarket.util.Constant.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : BaseFragment<FragmentSignUpBinding, SignUpViewModel>() {
    override val viewModel: SignUpViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "SignUpFragment - onCreateView() called")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "SignUpFragment - onViewCreated() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SignUpFragment - onStart() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SignUpFragment - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SignUpFragment - onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "SignUpOrInFragment - onDestroyView() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SignUpFragment - onDestroy() called")
    }
}