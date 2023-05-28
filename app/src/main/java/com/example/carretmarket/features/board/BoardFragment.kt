package com.example.carretmarket.features.board

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
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.network.model.Board
import com.example.carretmarket.databinding.FragmentBoardBinding
import com.example.carretmarket.features.board.post.PostingFragment
import com.example.carretmarket.features.home.HomeFragment
import com.example.carretmarket.util.Constant.TAG

class BoardFragment: BaseFragment<FragmentBoardBinding, BoardViewModel>() {
    override val viewModel: BoardViewModel by viewModels()

    private lateinit var adapter: BoardAdapter
    private var isFabOpen = false

    override fun observerViewModel() {
        initRecyclerView()
        initFloatingBar()
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

        mBinding.rvBoard.adapter = adapter
        mBinding.rvBoard.layoutManager = LinearLayoutManager(requireContext())
        // scroll event
        mBinding.rvBoard.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // recyclerView 아래 닿을 시 게시글 로딩
                if (!mBinding.rvBoard.canScrollVertically(1)) {
                    Log.d(TAG, "onBottom - onScrolled() called")
                    val boards = viewModel.getBoards(boardList.last().timestamp)
                    viewModel.addBoards(boards)
                }
            }
        })

        // recyclerView 를 가로로 만들기
        // rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        mBinding.swr.setOnRefreshListener {
            viewModel.reloadBoard()
            adapter.notifyItemRangeRemoved(0, boardList.size)
            mBinding.swr.isRefreshing = false
        }
    }

    private fun initFloatingBar() {
        mBinding.floatingBtn2.setOnClickListener {
            onClickFloatingBar()
        }

        mBinding.floatingBtn1.setOnClickListener {
            onClickFloatingBar()
            activity?.supportFragmentManager?.commit {
                replace(R.id.fl_main, PostingFragment())
            }
        }
    }

    private fun onClickFloatingBar() {
        Log.d(TAG, "MainActivity - toggleFab() called")
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