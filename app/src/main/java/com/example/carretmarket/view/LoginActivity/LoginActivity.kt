package com.example.carretmarket.view.LoginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.carretmarket.data.request.LoginRequest
import com.example.carretmarket.data.response.TokenResponse
import com.example.carretmarket.data.response.VerifyKeyResponse
import com.example.carretmarket.view.MainFragment.MainActivity
import com.example.carretmarket.databinding.ActivityLoginBinding
import com.example.carretmarket.utils.encryption.RSA
import com.example.carretmarket.utils.encryption.VerifyKeyFetcher
import com.example.carretmarket.utils.retrofit.Retrofit
import com.example.carretmarket.utils.session.Session
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    private lateinit var verifyKey: VerifyKeyResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        verifyKey = runBlocking {
            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
        }

        val mainIntent = Intent(this, MainActivity::class.java)

        binding.btnLogin.setOnClickListener {
            val pw = binding.etInpPw.text.toString()
            if (pw.isNotBlank()) return@setOnClickListener
            val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw)
            Retrofit.loginAPI.login(LoginRequest(binding.etInpId.text.toString(), pwEncrypted, verifyKey.verificationToken)).enqueue(object : Callback<TokenResponse> {
                override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                    if (response.code() == 200) {
                        val body = response.body()
                        Session.accessToken = body?.accessToken
                        Session.refreshToken = body?.refreshToken

                        startActivity(mainIntent)
                        ActivityCompat.finishAffinity(this@LoginActivity)
                        Log.d("LoginRequest", "Logged in maybe. ${Session.accessToken} ${Session.refreshToken}")
                    } else {
                        Log.d("LoginRequest", "Failed to login: ${response.code()} ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                    // TODO: show alert when failed
                    Log.d("LoginRequest", "Failed to login: ${t.stackTraceToString()}")
                }
            })
        }
    }
}