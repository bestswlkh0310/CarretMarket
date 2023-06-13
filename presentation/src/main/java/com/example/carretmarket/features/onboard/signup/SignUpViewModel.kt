package com.example.carretmarket.features.onboard.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.util.RSA
import com.example.domain.request.SignUpRequest
import com.example.domain.usecase.login.LoginUseCases
import com.example.domain.usecase.verify.VerifyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val verifyUseCases: VerifyUseCases,
    private val loginUseCases: LoginUseCases
): BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    fun onSignUpClick() {

        Log.d(TAG, "${id.value} ${pw.value} - onSignupClick() called")

        viewModelScope.launch {
            verifyUseCases.getVerifyKey().collect {
                Log.d(TAG, "SignUpViewModel - onSignUpClick() called")
                loginUseCases.register(SignUpRequest(
                    username = id.value!!,
                    email = email.value!!,
                    password = RSA.encrypt(it.publicKey, pw.value!!),
                    verificationToken = it.verificationToken
                )).collect {}
            }
        }
    }
}