package com.example.carretmarket.features.onboard.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.carretmarket.base.BaseViewModel
import com.example.data.model.VerifyKeyResponse
import com.example.carretmarket.util.Constant.TAG
import com.example.carretmarket.util.RSA

class SignUpViewModel: BaseViewModel() {
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    private lateinit var verifyKey: VerifyKeyResponse

    fun onSignUpClick() {

        Log.d(TAG, "$id $pw - onSignupClick() called")

//        verifyKey = runBlocking {
//            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
//        }
//        val startIntent = Intent(context, OnBoardActivity::class.java)
//        if (pw.isBlank()) return
        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw.value!!)

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

    companion object {
    }
}