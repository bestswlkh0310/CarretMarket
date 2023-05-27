package com.example.carretmarket.features.onMain

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseActivity
import com.example.carretmarket.databinding.ActivityOnmainBinding
import com.example.carretmarket.features.board.BoardFragment
import com.example.carretmarket.features.chat.ChatFragment
import com.example.carretmarket.features.home.HomeFragment
import com.example.carretmarket.features.map.MapFragment
import com.example.carretmarket.features.profile.ProfileFragment


class MainActivity : BaseActivity<ActivityOnmainBinding, MainViewModel>() {
    override val viewModel by viewModels<MainViewModel>()
    override val TAG: String = MainActivity::class.java.simpleName
    override val layoutRes = R.layout.activity_onmain

    private var backPressedTime : Long = 0
    private var backPressTime : Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBottomNav()
    }

    private fun initBottomNav() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
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

    override fun onBackPressed() {
        //2.5초이내에 한 번 더 뒤로가기 클릭 시
        if (System.currentTimeMillis() - backPressedTime < backPressTime) {
            super.onBackPressed()
            return
        }
        Toast.makeText(this, "한번 더 클릭 시 홈으로 이동됩니다.", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }
}