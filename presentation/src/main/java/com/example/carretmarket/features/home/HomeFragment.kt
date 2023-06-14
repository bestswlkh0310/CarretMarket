package com.example.carretmarket.features.home

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.base.BaseFragment
import com.example.domain.model.Item
import com.example.carretmarket.databinding.FragmentHomeBinding
import com.example.carretmarket.util.Constant.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val viewModel: HomeViewModel by viewModels()
    private lateinit var adapter : ItemAdapter
    private var isFabOpen = false

    override fun observerViewModel() {

        initToolBar()
        initFloatingBar()
        initRecyclerView()
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
        mBinding.rvItems.adapter = adapter
        mBinding.rvItems.layoutManager = LinearLayoutManager(requireContext())
    }


    private fun initToolBar() {
        // 동네 선택
        mBinding.tvGujida.setOnClickListener {
            Log.d(TAG, "MainActivity - onCreate() called")
        }
    }

    private fun initFloatingBar() {
        mBinding.floatingBtn2.setOnClickListener { onClickFloatingBar() }
        mBinding.floatingBtn1.setOnClickListener { onClickFloatingBar() }
    }

    private fun onClickFloatingBar() {
        if (isFabOpen) {
            val anim = ObjectAnimator.ofFloat(mBinding.floatingBtn1, "translationY", 0f).apply { start() }
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(anim)
                    mBinding.floatingBtn1.visibility = View.INVISIBLE
                }
            })
        } else {
            ObjectAnimator.ofFloat(mBinding.floatingBtn1, "translationY", -150f).apply { start() }
            mBinding.floatingBtn1.visibility = View.VISIBLE
        }
        isFabOpen = !isFabOpen
    }
}