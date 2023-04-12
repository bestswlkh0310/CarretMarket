package com.example.carretmarket.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivitySignupBinding
import com.example.carretmarket.viewmodel.SignupViewModel

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var viewModel: SignupViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        viewModel = ViewModelProvider(this).get(SignupViewModel::class.java)
        binding.lifecycleOwner = this
        binding.signup = viewModel

        binding.btnSignup.setOnClickListener {
            viewModel.onSignupClick(this)
        }
    }
}