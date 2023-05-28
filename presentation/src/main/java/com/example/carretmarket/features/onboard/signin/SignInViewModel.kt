package com.example.carretmarket.features.onboard.signin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.SignInRequest
import com.example.carretmarket.network.response.TokenResponse
import com.example.carretmarket.network.response.VerifyKeyResponse
import com.example.carretmarket.util.RSA
import com.example.carretmarket.util.Session
import com.example.carretmarket.util.VerifyKeyFetcher
import com.example.carretmarket.util.Constant.TAG
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class SignInViewModel: BaseViewModel() {
    private lateinit var verifyKey: VerifyKeyResponse
    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun onClickLogin() {
        Log.d(TAG, "id - $id pw - $pw - onLoginClick() called")

//        val mainIntent = Intent(context, MainActivity::class.java)
        if (pw.value == null) return
//        verifyKey = runBlocking {
//            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
//        }

        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw.value!!)
        val call = RetrofitClient.loginAPI.login(
            SignInRequest(
                id.value!!,
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
//                    context.startActivity(mainIntent)
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