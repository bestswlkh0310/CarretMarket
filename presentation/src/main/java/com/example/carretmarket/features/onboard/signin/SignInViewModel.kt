package com.example.carretmarket.features.onboard.signin

import android.content.Intent
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.features.onmain.MainActivity
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.util.RSA
import com.example.carretmarket.wiget.CarretApplication
import com.example.domain.request.SignInRequest
import com.example.domain.usecase.login.LoginUseCases
import com.example.domain.usecase.verify.VerifyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val verifyUseCases: VerifyUseCases,
    private val loginUseCases: LoginUseCases
): BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun onClickLogin() {
        Log.d(TAG, "id - ${id.value} pw - ${pw.value} - onLoginClick() called")

        if (id.value == null || pw.value == null) return

        viewModelScope.launch {
            verifyUseCases.getVerifyKey().collect {
                loginUseCases.login(
                    SignInRequest(
                        username = id.value!!,
                        password = RSA.encrypt(it.publicKey, pw.value!!),
                        verificationToken = it.verificationToken
                    )
                ).collect {
                    with(CarretApplication.prefs) {
                        refreshToken = it.refreshToken
                        accessToken = it.accessToken
                    }
                    viewEvent(EVENT_ON_CLICK_SIGN_IN)
                }
            }
        }
    }

    companion object {
        const val EVENT_ON_CLICK_SIGN_IN = 0
    }
}