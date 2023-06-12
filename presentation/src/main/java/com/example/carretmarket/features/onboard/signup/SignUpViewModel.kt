package com.example.carretmarket.features.onboard.signup

import android.util.Log
import android.util.LogPrinter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.data.model.VerifyKeyResponse
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.util.RSA
import com.example.domain.request.SignUpRequest
import com.example.domain.usecase.login.LoginUseCases
import com.example.domain.usecase.verify.VerifyUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
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
                loginUseCases.register(SignUpRequest(
                    id.value!!,
                    email.value!!,
                    RSA.encrypt(it.publicKey, pw.value!!),
                    it.verificationToken
                ))
            }
        }

//        verifyKey = runBlocking {
//            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
//        }
//        val startIntent = Intent(context, OnBoardActivity::class.java)
//        if (pw.isBlank()) return
//        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw.value!!)

        /*val call = RetrofitClient.loginAPI.register(
            SignUpRequest(
                id.value!!,
                email.value!!,
                pwEncrypted,
                verifyKey.verificationToken
            )
        )
        call.enqueue(object : Callback<BaseResponse<Unit>> {
            override fun onResponse(call: Call<BaseResponse<Unit>>, response: Response<BaseResponse<Unit>>) {
                if (response.code() == 200) {
//                    context.startActivity(startIntent)
                }
            }

            override fun onFailure(call: Call<BaseResponse<Unit>>, t: Throwable) {
                Log.d("RegisterRequest", "Failed to register: ${t.stackTraceToString()}")
            }
        })*/
    }
}