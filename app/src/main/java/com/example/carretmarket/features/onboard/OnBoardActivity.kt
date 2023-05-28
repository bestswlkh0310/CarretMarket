package com.example.carretmarket.features.onboard

import android.os.Bundle
import androidx.activity.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnBoardBinding
import com.example.carretmarket.features.onboard.signuporin.SignUpOrInFragment

class OnBoardActivity : BaseActivity<ActivityOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().add(R.id.fl_on_board, SignUpOrInFragment()).commit()
    }
    override fun observerViewModel() {}
}