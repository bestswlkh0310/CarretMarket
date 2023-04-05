package com.example.carretmarket.view.LoginActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.carretmarket.view.MainFragment.MainActivity
import com.example.carretmarket.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val binding: ActivityLoginBinding by lazy { ActivityLoginBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val mainIntent = Intent(this, MainActivity::class.java)

        binding.btnLogin.setOnClickListener {
            startActivity(mainIntent)
            ActivityCompat.finishAffinity(this)
        }
    }
}