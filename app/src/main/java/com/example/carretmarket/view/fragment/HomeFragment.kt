package com.example.carretmarket.view.fragment

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
import com.example.carretmarket.view.adapter.ItemAdapter

class HomeFragment: Fragment() {
    private val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
//    private lateinit var viewModel: HomeViewModel
    private var isFabOpen = false
    private val 임시list: List<Item> by lazy { arrayListOf(
        Item("na", 213),
        Item("asgfd", 143524),
        Item("hgsf", 456),
        Item("xvcb", 87),
    ) }

    val adapter by lazy { ItemAdapter(임시list) }
    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rv = binding.rvItems

        // viewModel 초기화
        /*viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.lifecycleOwner = this
        binding.home = viewModel*/

        // Adapter, LayoutManager 연결
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        // 동네 선택 action bar
        binding.tvGujida.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
        }

        // mainFloatingBtn
        binding.floatingBtn2.setOnClickListener {
            toggleFab()
        }

        // postFloatingBtn
        binding.floatingBtn1.setOnClickListener {
            toggleFab()
            // TODO: InputActivity -> 상품 올리기 Activity
            //startActivity(Intent(activity, InputActivity::class.java))
        }

        return binding.root
    }

    private fun toggleFab() {
        Log.d(TAG, "MainActivity - toggleFab() called")
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