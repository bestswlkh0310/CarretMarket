package com.example.carretmarket.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.SignInRequest
import com.example.carretmarket.network.response.TokenResponse
import com.example.carretmarket.network.response.VerifyKeyResponse
import com.example.carretmarket.util.RSA
import com.example.carretmarket.util.Session
import com.example.carretmarket.util.VerifyKeyFetcher
import com.example.carretmarket.view.activity.MainActivity
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class SignInViewModel: ViewModel() {
    val TAG: String = "로그"

    private lateinit var verifyKey: VerifyKeyResponse

    fun onClickLogin(context: Context, id: String, pw: String) {
        Log.d(TAG, "id - $id pw - $pw - onLoginClick() called")

        val mainIntent = Intent(context, MainActivity::class.java)
        if (pw.isNotBlank()) return
        verifyKey = runBlocking {
            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
        }

        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw)
        val call = RetrofitClient.loginAPI.login(
            SignInRequest(
                id,
                pwEncrypted,
                verifyKey.verificationToken
            )
        )

        call.enqueue(object : Callback<BaseResponse<TokenResponse>> {
            override fun onResponse(call: Call<BaseResponse<TokenResponse>>, response: Response<BaseResponse<TokenResponse>>) {
                if (response.code() == 200) {
                    val body = response.body()?.data
                    Session.accessToken = body?.accessToken
                    Session.refreshToken = body?.refreshToken
                    context.startActivity(mainIntent)
                    Log.d("LoginRequest", "Logged in maybe. ${Session.accessToken} ${Session.refreshToken}")
                } else {
                    Log.d("LoginRequest", "Failed to login: ${response.code()} ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<BaseResponse<TokenResponse>>, t: Throwable) {
                Log.d("LoginRequest", "Failed to login: ${t.stackTraceToString()}")
            }
        })
    }
}