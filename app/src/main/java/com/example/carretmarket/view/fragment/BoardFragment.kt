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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.network.model.Board
import com.example.carretmarket.databinding.FragmentBoardBinding
import com.example.carretmarket.databinding.FragmentHomeBinding
import com.example.carretmarket.view.activity.PostActivity
import com.example.carretmarket.view.adapter.BoardAdapter
import com.example.carretmarket.viewmodel.BoardViewModel

class BoardFragment: Fragment() {
    //    private lateinit var viewModel: HomeViewModel
    private lateinit var viewModel: BoardViewModel
    private lateinit var binding: FragmentBoardBinding
    private var isFabOpen = false

    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = FragmentBoardBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(BoardViewModel::class.java)

        val rv = binding.rvBoard
        val itemlist = arrayListOf(
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
            Board(1234, 12345,"sdaf"),
        )
        viewModel.addItems(itemlist)

        val adapter = BoardAdapter(viewModel.itemList)
        // Adapter, LayoutManager 연결
        // rv.adapter = BoardAdapter(itemlist)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!rv.canScrollVertically(1)) {
                    Log.d(TAG, "onBottom - onScrolled() called")
                    // TODO: timestamp 전송 후 값 저장
                }
                if (!rv.canScrollVertically(-1)) {
                    Log.d(TAG, "onTop - onScrolled() called")
                    // TODO: clear() 후 new 받아오기

                }
            }
        })

        binding.swr.setOnRefreshListener {
            viewModel.reloadItem()
            adapter.notifyItemRangeRemoved(0, itemlist.size)
            binding.swr.isRefreshing = false
        }

        // recyclerView를 가로로 만들기
        // rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.floatingBtn2.setOnClickListener {
            toggleFab()
        }

        binding.floatingBtn1.setOnClickListener {
            toggleFab()
            startActivity(Intent(activity, PostActivity::class.java))
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