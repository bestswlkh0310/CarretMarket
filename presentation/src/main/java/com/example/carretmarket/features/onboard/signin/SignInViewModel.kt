package com.example.carretmarket.features.onboard.signin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.data.model.VerifyKeyResponse
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.wiget.CarretApplication
import com.example.domain.request.SignInRequest
import com.example.domain.usecase.login.LoginUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
): BaseViewModel() {

    private val _getVerifyKeyState = MutableSharedFlow<VerifyKeyResponse>()
    val getVerifyKeyState: SharedFlow<VerifyKeyResponse> = _getVerifyKeyState

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun onClickLogin() {
        Log.d(TAG, "id - ${id.value} pw - ${pw.value} - onLoginClick() called")

        if (id.value == null || pw.value == null) return

        viewModelScope.launch {
            loginUseCases.login(
                SignInRequest(
                    id.value!!,
                    pw.value!!,
                    CarretApplication.prefs.verificationToken
                )
            ).collect {
                viewEvent(EVENT_ON_CLICK_SIGN_IN)
                with(CarretApplication.prefs) {
                    accessToken = it.accessToken
                    refreshToken = it.refreshToken
                }
            }
        }
    }

    companion object {
        const val EVENT_ON_CLICK_SIGN_IN = 0
    }
}