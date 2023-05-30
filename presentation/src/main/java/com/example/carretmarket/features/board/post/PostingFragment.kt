package com.example.carretmarket.features.board.post

import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentPostingBinding

class PostingFragment : BaseFragment<FragmentPostingBinding, PostingViewModel>() {
    override val viewModel: PostingViewModel by viewModels()


    override fun observerViewModel() {}
}