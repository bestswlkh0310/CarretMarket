package com.example.carretmarket.features.auth

import android.os.Bundle
import androidx.activity.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnboardBinding

class OnBoardActivity : BaseActivity<ActivityOnboardBinding, OnBoardViewModel>() {
    override val viewModel by viewModels<OnBoardViewModel>()
    override val TAG: String = OnBoardActivity::class.java.simpleName
    override val layoutRes = R.layout.activity_onboard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Change to Navigation
        val onBoardFragment = OnBoardFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_start, onBoardFragment).commit()
    }
}