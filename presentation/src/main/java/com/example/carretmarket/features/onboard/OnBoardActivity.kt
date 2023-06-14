package com.example.carretmarket.features.onboard

import android.content.Intent
import androidx.activity.viewModels
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnBoardBinding
import com.example.carretmarket.features.onmain.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardActivity : BaseActivity<ActivityOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()

    override fun observerViewModel() {}

    fun startMainActivity() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}