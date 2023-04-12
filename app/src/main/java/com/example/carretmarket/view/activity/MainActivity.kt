package com.example.carretmarket.view.activity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.carretmarket.R
import com.example.carretmarket.databinding.ActivityMainBinding
import com.example.carretmarket.view.fragment.*


class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var homeFragment: HomeFragment
    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
//        binding.toolbar.setNavigationIcon(R.drawable.ic_alert)

        binding.tvGujida.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
        }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top_nav, menu)

        return super.onCreateOptionsMenu(menu)
    }
}