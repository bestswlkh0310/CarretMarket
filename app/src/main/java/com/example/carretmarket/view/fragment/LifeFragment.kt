package com.example.carretmarket.view.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.network.model.Life
import com.example.carretmarket.databinding.FragmentLifeBinding
import com.example.carretmarket.view.activity.PostingActivity
import com.example.carretmarket.view.adapter.LifeAdapter

class LifeFragment: Fragment() {
    private val binding: FragmentLifeBinding by lazy { FragmentLifeBinding.inflate(layoutInflater) }
    private var isFabOpen = false

    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rv = binding.rvLife
        val lifeList = listOf(
            Life("title", 12345,142536),
            Life("ㅁㄴㅇ", 12345,425),
            Life("ㅁㄴㅇ", 32456,765),
            Life("ㅁㄴㅇ", 24356,765),
            Life("jh", 132435,7654),
        )

        // Adapter, LayoutManager 연결
        rv.adapter = LifeAdapter(lifeList)
        rv.layoutManager = LinearLayoutManager(requireContext())

        // recyclerView를 가로로 만들기
        // rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.floatingBtn2.setOnClickListener {
            toggleFab()
        }

        binding.floatingBtn1.setOnClickListener {
            toggleFab()
            startActivity(Intent(activity, PostingActivity::class.java))
        }

        binding.refresh.setOnRefreshListener {
            binding.refresh.isRefreshing = false

        }

        return binding.root
    }

    private fun toggleFab() {
        Log.d(HomeFragment.TAG, "MainActivity - toggleFab() called")
        if (isFabOpen) {
            val anim = ObjectAnimator.ofFloat(binding.floatingBtn1, "translationY", 0f).apply { start() }
            // 활성화 비활성화
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(anim)
                    binding.floatingBtn1.visibility = View.INVISIBLE
                }
            })
        } else {
             val anim = ObjectAnimator.ofFloat(binding.floatingBtn1, "translationY", -150f).apply { start() }
            binding.floatingBtn1.visibility = View.VISIBLE
        }
        isFabOpen = !isFabOpen
    }
}