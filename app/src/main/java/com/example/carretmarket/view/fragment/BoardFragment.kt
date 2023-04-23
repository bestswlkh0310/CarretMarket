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
import com.example.carretmarket.view.activity.PostingActivity
import com.example.carretmarket.view.adapter.BoardAdapter
import com.example.carretmarket.viewmodel.BoardViewModel

class BoardFragment: Fragment() {
    private lateinit var viewModel: BoardViewModel
    private lateinit var binding: FragmentBoardBinding
    private lateinit var adapter: BoardAdapter
    private var isFabOpen = false

    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // binding, viewModel 설정
        binding = FragmentBoardBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[BoardViewModel::class.java]

        // 초기화
        initRecyclerView()
        initFloatingBar()

        return binding.root
    }

    private fun initRecyclerView() {
        val boardList = arrayListOf(
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
        viewModel.addBoards(boardList)

        adapter = BoardAdapter(viewModel.boardList)
        // Adapter, LayoutManager 연결
        // rv.adapter = BoardAdapter(itemlist)
        binding.rvBoard.adapter = adapter
        binding.rvBoard.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBoard.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!binding.rvBoard.canScrollVertically(1)) {
                    Log.d(TAG, "onBottom - onScrolled() called")
                    val boards = viewModel.getBoards(boardList.last().timestamp)
                    viewModel.addBoards(boards)
                    // TODO: timestamp 전송 후 값 저장
                }/*
                if (!binding.rvBoard.canScrollVertically(-1)) {
                    Log.d(TAG, "onTop - onScrolled() called")
                    // TODO: clear() 후 new 받아오기
                }*/
            }
        })

        // recyclerView를 가로로 만들기
        // rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.swr.setOnRefreshListener {
            viewModel.reloadBoard()
            adapter.notifyItemRangeRemoved(0, boardList.size)
            binding.swr.isRefreshing = false
        }
    }

    private fun initFloatingBar() {
        binding.floatingBtn2.setOnClickListener {
            onClickFloatingBar()
        }

        binding.floatingBtn1.setOnClickListener {
            onClickFloatingBar()
            startActivity(Intent(activity, PostingActivity::class.java))
        }
    }

    private fun onClickFloatingBar() {
        Log.d(HomeFragment.TAG, "MainActivity - toggleFab() called")
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