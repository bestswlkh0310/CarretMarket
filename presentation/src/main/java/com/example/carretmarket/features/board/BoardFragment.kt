package com.example.carretmarket.features.board

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.domain.model.Board
import com.example.carretmarket.databinding.FragmentBoardBinding
import com.example.carretmarket.util.Constant.TAG
import com.example.domain.model.BoardList
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BoardFragment: BaseFragment<FragmentBoardBinding, BoardViewModel>() {
    override val viewModel: BoardViewModel by viewModels()

    private lateinit var adapter: BoardAdapter
    private var isFabOpen = false


    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                BoardViewModel.EVENT_ON_CLICK_POST -> findNavController().navigate(R.id.action_boardFragment_to_postFragment)
                BoardViewModel.EVENT_ON_CLICK_FLAOTING_BAR -> onClickFloatingBar()
            }
        }
        viewModel.viewModelScope.launch {
            viewModel.getBoardState.collect { board ->
                Log.d(TAG, "$board - observerViewModel() called")
            }
        }

        viewModel.viewModelScope.launch {
            viewModel.getBoardsState.collect { boards ->
                viewModel.addBoards(boards)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val boardList = arrayListOf(
            BoardList(1,12, "123"),
            BoardList(1,12, "123"),
            BoardList(1,12, "123"),
            BoardList(1,12, "123"),
            BoardList(1,12, "123"),
            BoardList(1,12, "123"),
            BoardList(1,12, "123"),
        )
        viewModel.addBoards(boardList)
        adapter = BoardAdapter(viewModel.boardList)

        mBinding.rvBoard.adapter = adapter
        mBinding.rvBoard.layoutManager = LinearLayoutManager(requireContext())
        mBinding.rvBoard.addOnScrollListener(object: RecyclerView.OnScrollListener() {; override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {; super.onScrolled(recyclerView, dx, dy)
                // recyclerView 아래 닿 -> 게시글 로딩
                if (!mBinding.rvBoard.canScrollVertically(1)) {
                    viewModel.getBoards(boardList.last().timestamp)
                }
            }
        })

        mBinding.swr.setOnRefreshListener {
            viewModel.reloadBoard()
            adapter.notifyItemRangeRemoved(0, boardList.size)
            mBinding.swr.isRefreshing = false
        }
    }

    private fun onClickFloatingBar() {
        if (isFabOpen) {
            val anim = ObjectAnimator.ofFloat(mBinding.floatingBtn1, "translationY", 0f).apply { start() }
            anim.addListener(object : AnimatorListenerAdapter() {; override fun onAnimationEnd(animation: Animator) {; super.onAnimationEnd(anim)
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