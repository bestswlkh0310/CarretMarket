package com.example.carretmarket.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivityLoginBinding
import com.example.carretmarket.view.fragment.OnBoardFragment

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setContentView(binding.root)

//        val loginIntent = Intent(this, LoginActivity::class.java)
//        val signupIntent = Intent(this, SignupActivity::class.java)

        val onBoardFragment = OnBoardFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_start, onBoardFragment).commit()

//        binding.btnLogin.setOnClickListener { startActivity(loginIntent) }
//        binding.btnSignup.setOnClickListener { startActivity(signupIntent) }
    }
}