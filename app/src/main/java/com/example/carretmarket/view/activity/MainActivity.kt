package com.example.carretmarket.view.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.view.isVisible
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
    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setSupportActionBar(binding.toolbar) // ActionBar 설정

        initBottomNav()

        binding.floatingBtn2.setOnClickListener {
            toggleFab()
        }

        binding.floatingBtn1.setOnClickListener {
            toggleFab()

            val inputIntent = Intent(this, InputActivity::class.java)
            startActivity(inputIntent)
        }

        binding.tvGujida.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
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
    private fun toggleFab() {
        if (isFabOpen) {
            Log.d(TAG, "MainActivity - toggleFab() called")
            val anim = ObjectAnimator.ofFloat(binding.floatingBtn1, "translationY", 0f).apply { start() }
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(anim)
                    binding.floatingBtn1.visibility = View.INVISIBLE
                }
            })
        } else {
            Log.d(TAG, "MainActivity - toggleFab() called")
            val anim = ObjectAnimator.ofFloat(binding.floatingBtn1, "translationY", -150f).apply { start() }
            binding.floatingBtn1.visibility = View.VISIBLE
        }
        isFabOpen = !isFabOpen
    }

    private fun initBottomNav() {
        binding.bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
                }
                R.id.menu_life -> {
                    val lifeFragment = LifeFragment()
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
}