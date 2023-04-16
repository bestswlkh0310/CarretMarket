package com.example.carretmarket.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivityMainBinding
import com.example.carretmarket.view.fragment.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeFragment: HomeFragment
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
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
                }
                R.id.menu_life -> {
                    val lifeFragment = BoardFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, lifeFragment).commit()
                }
                R.id.menu_map -> {
                    val mapFragment = MapFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, mapFragment).commit()
                }
                R.id.menu_chat -> {
                    val chatFragment = ChatFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, chatFragment).commit()
                }
                R.id.menu_profile -> {
                    val profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
                }
            }
            true
        }
        homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()
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