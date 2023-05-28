package com.example.carretmarket.features.onboard.signup

import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.SignUpRequest
import com.example.carretmarket.network.response.VerifyKeyResponse
import com.example.carretmarket.util.RSA
import com.example.carretmarket.util.VerifyKeyFetcher
import com.example.carretmarket.features.onboard.OnBoardActivity
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class SignUpViewModel: BaseViewModel() {
    var id: String = ""
    val pw: String = ""
    val email: String = ""
    val TAG: String = "로그"

    private lateinit var verifyKey: VerifyKeyResponse

    fun onSignupClick(context: Context) {

        Log.d(TAG, "$id $pw - onSignupClick() called")

        verifyKey = runBlocking {
            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
        }
        val startIntent = Intent(context, OnBoardActivity::class.java)
        if (pw.isBlank()) return
        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw)

        val call = RetrofitClient.loginAPI.register(
            SignUpRequest(
                id,
                email,
                pwEncrypted,
                verifyKey.verificationToken
            )
        )
        call.enqueue(object : Callback<BaseResponse<Unit>> {
            override fun onResponse(call: Call<BaseResponse<Unit>>, response: Response<BaseResponse<Unit>>) {
                if (response.code() == 200) {
                    context.startActivity(startIntent)
                }
            }

            override fun onFailure(call: Call<BaseResponse<Unit>>, t: Throwable) {
                Log.d("RegisterRequest", "Failed to register: ${t.stackTraceToString()}")
            }
        })
    }
}