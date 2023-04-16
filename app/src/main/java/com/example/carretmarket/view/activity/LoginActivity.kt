package com.example.carretmarket.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivityLoginBinding
import com.example.carretmarket.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        // 초기화
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding.lifecycleOwner = this
        binding.login = viewModel

        // 로그인
        binding.btnLogin.setOnClickListener {
            viewModel.onClickLogin(this,
                binding.etInpId.text.toString(),
                binding.etInpPw.text.toString()
            )
        }
    }
}