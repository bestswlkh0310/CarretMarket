package com.example.carretmarket.features.onboard

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.R
import com.example.carretmarket.network.model.Board
import com.example.carretmarket.databinding.FragmentBoardBinding
import com.example.carretmarket.features.onboard.post.PostingFragment
import com.example.carretmarket.features.home.HomeFragment

class BoardFragment: Fragment() {
    private val viewModel: BoardViewModel by viewModels()
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

        // 초기화
        initRecyclerView()
        initFloatingBar()

        return binding.root
    }

    private fun initRecyclerView() {
//        val boardList = viewModel.getBoards()
        val boardList = arrayListOf(
            Board(1,12, "123"),
            Board(1,12, "123"),
            Board(1,12, "123"),
            Board(1,12, "123"),
            Board(1,12, "123"),
            Board(1,12, "123"),
            Board(1,12, "123"),
            Board(1,12, "12313123123"),
            Board(1,12, "123"),
            Board(1,12, "123123123"),
            Board(1,12, "123"),
        )
        viewModel.addBoards(boardList)
        adapter = BoardAdapter(viewModel.boardList)

        binding.rvBoard.adapter = adapter
        binding.rvBoard.layoutManager = LinearLayoutManager(requireContext())
        // scroll event
        binding.rvBoard.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // recyclerView 아래 닿을 시 게시글 로딩
                if (!binding.rvBoard.canScrollVertically(1)) {
                    Log.d(TAG, "onBottom - onScrolled() called")
                    val boards = viewModel.getBoards(boardList.last().timestamp)
                    viewModel.addBoards(boards)
                }
            }
        })

        // recyclerView 를 가로로 만들기
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
            activity?.supportFragmentManager?.commit {
                replace(R.id.fl_main, PostingFragment())
            }
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