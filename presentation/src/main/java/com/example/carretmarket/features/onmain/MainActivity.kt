package com.example.carretmarket.features.onmain

import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityOnMainBinding, MainViewModel>() {
    override val viewModel by viewModels<MainViewModel>()

    override fun observerViewModel() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_on_main) as NavHostFragment
        val navController = navHostFragment.findNavController()
        mBinding.bottomNav.setupWithNavController(navController)
    }
}