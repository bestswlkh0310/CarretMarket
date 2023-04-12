package com.example.carretmarket.viewmodel

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.request.RegisterRequest
import com.example.carretmarket.network.response.VerifyKeyResponse
import com.example.carretmarket.util.RSA
import com.example.carretmarket.util.VerifyKeyFetcher
import com.example.carretmarket.view.activity.StartActivity
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class SignupViewModel: ViewModel() {
    var id: String = ""
    val pw: String = ""
    val TAG: String = "로그"

    private lateinit var verifyKey: VerifyKeyResponse

    fun onSignupClick(context: Context) {

        Log.d(TAG, "${id} ${pw} - onSignupClick() called")

        verifyKey = runBlocking {
            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
        }
        val startIntent = Intent(context, StartActivity::class.java)
        if (pw.isBlank()) return
        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw)

        val call = RetrofitClient.loginAPI.register(RegisterRequest(id, pwEncrypted, verifyKey.verificationToken))

        call.enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code() == 200) {
                    context.startActivity(startIntent)
                }
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("RegisterRequest", "Failed to register: ${t.stackTraceToString()}")
            }
        })
    }
}