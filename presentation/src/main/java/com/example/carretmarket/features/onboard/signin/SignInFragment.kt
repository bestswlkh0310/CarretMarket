package com.example.carretmarket.features.onboard.signin

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentSignInBinding
import com.example.carretmarket.util.Constant.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>() {
    override val viewModel: SignInViewModel by viewModels()

    override fun observerViewModel() {
        bindingViewEvent { event ->
            with(SignInViewModel) {
                when (event) {
                    EVENT_VERIFY_KEY -> {
                        Log.d(TAG, "SignInFragment - observerViewModel() called")
                    }
                }
            }
        }

        viewModel.viewModelScope.launch {
            viewModel.getVerifyKeyState.collect {
                Log.d(TAG, "${it.publicKey} - observerViewModel() called")
            }
        }
    }
}