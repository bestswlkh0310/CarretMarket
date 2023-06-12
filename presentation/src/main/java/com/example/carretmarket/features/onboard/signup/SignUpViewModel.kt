package com.example.carretmarket.features.onboard.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.data.model.VerifyKeyResponse
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.util.RSA
import com.example.domain.usecase.verify.VerifyUseCases
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val verifyUseCases: VerifyUseCases
): BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    fun onSignUpClick() {

        Log.d(TAG, "${id.value} ${pw.value} - onSignupClick() called")

        viewModelScope.launch {
            verifyUseCases.getVerifyKey().collect {
                
                it.publicKey
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