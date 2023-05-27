package com.example.carretmarket.features.home

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.network.model.Item
import com.example.carretmarket.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    companion object {
        const val TAG: String = "로그"
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter : ItemAdapter
    private var isFabOpen = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initToolBar()
        initFloatingBar()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        // 임시 리스트
        val itemList = arrayListOf(
            Item("na", 213),
            Item("asgfd", 143524),
            Item("hgsf", 456),
            Item("xvcb", 87),
        )
        adapter = ItemAdapter(itemList)
        binding.rvItems.adapter = adapter
        binding.rvItems.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initToolBar() {
        // 동네 선택
        binding.tvGujida.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
        }
    }

    private fun initFloatingBar() {
        binding.floatingBtn2.setOnClickListener { onClickFloatingBar() }

        binding.floatingBtn1.setOnClickListener { onClickFloatingBar() }
    }

    private fun onClickFloatingBar() {
        if (isFabOpen) {
            val anim = ObjectAnimator.ofFloat(binding.floatingBtn1, "translationY", 0f).apply { start() }
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(anim)
                    binding.floatingBtn1.visibility = View.INVISIBLE
                }
            })
        } else {
            ObjectAnimator.ofFloat(binding.floatingBtn1, "translationY", -150f).apply { start() }
            binding.floatingBtn1.visibility = View.VISIBLE
        }
        isFabOpen = !isFabOpen
    }
}