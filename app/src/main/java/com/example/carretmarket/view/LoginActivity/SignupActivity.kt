package com.example.carretmarket.view.LoginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.carretmarket.data.request.RegisterRequest
import com.example.carretmarket.data.response.VerifyKeyResponse
import com.example.carretmarket.view.MainFragment.MainActivity
import com.example.carretmarket.databinding.ActivitySignupBinding
import com.example.carretmarket.utils.encryption.RSA
import com.example.carretmarket.utils.encryption.VerifyKeyFetcher
import com.example.carretmarket.utils.retrofit.Retrofit
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.system.exitProcess

class SignupActivity : AppCompatActivity() {
    private val binding: ActivitySignupBinding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    private lateinit var verifyKey: VerifyKeyResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        verifyKey = runBlocking {
            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
        }

        val startIntent = Intent(this, StartActivity::class.java)

        binding.btnSignup.setOnClickListener {
            val pw = binding.etInpPw.text.toString()
            if (pw.isBlank()) return@setOnClickListener
            val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw)

            Retrofit.loginAPI.register(RegisterRequest(binding.etInpId.text.toString(), pwEncrypted, verifyKey.verificationToken)).enqueue(object : Callback<Unit> {
                override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                    if (response.code() == 200) {

                        ActivityCompat.finishAffinity(this@SignupActivity)
                        startActivity(startIntent)
                    }
                }

                override fun onFailure(call: Call<Unit>, t: Throwable) {
                    Log.d("RegisterRequest", "Failed to register: ${t.stackTraceToString()}")
                }

            })
        }
    }
}