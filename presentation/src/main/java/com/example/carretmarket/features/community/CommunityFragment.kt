package com.example.carretmarket.features.community

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentCommunityBinding
import com.example.carretmarket.features.community.CommunityViewModel.Companion.EVENT_ON_CLICK_FLAOTING_BAR
import com.example.carretmarket.features.community.CommunityViewModel.Companion.EVENT_ON_CLICK_POST
import com.example.carretmarket.util.Constant.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommunityFragment: BaseFragment<FragmentCommunityBinding, CommunityViewModel>() {
    override val viewModel: CommunityViewModel by viewModels()

    private lateinit var adapter: CommunityAdapter
    private var isFabOpen = false

    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                EVENT_ON_CLICK_POST -> findNavController().navigate(R.id.action_communityFragment_to_postFragment)
                EVENT_ON_CLICK_FLAOTING_BAR -> onClickFloatingBar()
            }
        }

        viewModel.boardsData.observe(this) { boards ->
            if (boards != null) {
                boards.forEach {
                    Log.d(TAG, "$it - observerViewModel() called")
                }
                viewModel.addBoards(boards)
                adapter.notifyItemRangeInserted(viewModel.boardList.lastIndex, boards.size)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        viewModel.boardsData.value = null
        adapter = CommunityAdapter(viewModel.boardList) { board ->
            val action = CommunityFragmentDirections.actionCommunityFragmentToBoardFragment(board.id)
            findNavController().navigate(action)
        }

        mBinding.rvBoard.adapter = adapter
        mBinding.rvBoard.layoutManager = LinearLayoutManager(context)
        reload()

        /*mBinding.rvBoard.addOnScrollListener(object: RecyclerView.OnScrollListener() {; override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {; super.onScrolled(recyclerView, dx, dy)
                if (!mBinding.rvBoard.canScrollVertically(1)) {
                    viewModel.getBoards(viewModel.boardList.last().timestamp)
                }
            }
        })*/

        mBinding.swr.setOnRefreshListener {
            reload()
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

    private fun reload() {
        val boardListSize = viewModel.boardList.size
        viewModel.reloadBoard()
        if (boardListSize > 0)
            adapter.notifyItemRangeRemoved(0, boardListSize)
        viewModel.getBoards()
    }
}