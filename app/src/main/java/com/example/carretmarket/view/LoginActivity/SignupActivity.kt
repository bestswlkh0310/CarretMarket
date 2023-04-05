package com.example.carretmarket.view.LoginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.carretmarket.view.MainFragment.MainActivity
import com.example.carretmarket.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private val binding: ActivitySignupBinding by lazy { ActivitySignupBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mainIntent = Intent(this, MainActivity::class.java)

        binding.btnSignup.setOnClickListener {
            ActivityCompat.finishAffinity(this)
            startActivity(mainIntent)
        }
    }
}