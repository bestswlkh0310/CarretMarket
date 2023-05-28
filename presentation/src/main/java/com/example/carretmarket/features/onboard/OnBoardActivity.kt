package com.example.carretmarket.features.onboard

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnBoardBinding
import com.example.carretmarket.features.onboard.signuporin.SignUpOrInFragment
import com.example.carretmarket.util.Constant.TAG

class OnBoardActivity : BaseActivity<ActivityOnBoardBinding, OnBoardViewModel>() {
    override val viewModel: OnBoardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.commit {
            add(R.id.fl_on_board, SignUpOrInFragment())
        }
    }

    override fun observerViewModel() {}

}