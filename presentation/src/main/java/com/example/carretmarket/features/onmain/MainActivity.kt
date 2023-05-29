package com.example.carretmarket.features.onmain

import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnMainBinding
import com.example.carretmarket.features.board.BoardFragment
import com.example.carretmarket.features.chat.ChatFragment
import com.example.carretmarket.features.home.HomeFragment
import com.example.carretmarket.features.map.MapFragment
import com.example.carretmarket.features.profile.ProfileFragment


class MainActivity : BaseActivity<ActivityOnMainBinding, MainViewModel>() {
    override val viewModel by viewModels<MainViewModel>()

    private var backPressedTime : Long = 0
    private var backPressTime : Long = 2500

    override fun observerViewModel() {
        initBottomNav()
    }

    private fun initBottomNav() {
        mBinding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    supportFragmentManager.commit {
                        replace(R.id.fl_main, HomeFragment())
                    }
                }

                R.id.menu_life -> {
                    supportFragmentManager.commit {
                        replace(R.id.fl_main, BoardFragment())
                    }
                }

                R.id.menu_map -> {
                    supportFragmentManager.commit {
                        replace(R.id.fl_main, MapFragment())
                    }
                }

                R.id.menu_chat -> {
                    supportFragmentManager.commit {
                        replace(R.id.fl_main, ChatFragment())
                    }
                }

                R.id.menu_profile -> {
                    supportFragmentManager.commit {
                        replace(R.id.fl_main, ProfileFragment())
                    }
                }
            }
            true
        }
    }
}