package com.example.carretmarket.view.activity

import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivityMainBinding
import com.example.carretmarket.view.fragment.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG: String = "로그"

    private var backPressedTime : Long = 0
    private var backPressTime : Long = 2500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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