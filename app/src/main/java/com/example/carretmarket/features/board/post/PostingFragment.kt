package com.example.carretmarket.features.board.post

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentPostingBinding

class PostingFragment : BaseFragment<FragmentPostingBinding, PostingViewModel>() {
    override val viewModel: PostingViewModel by viewModels()

    override fun observerViewModel() {
        Log.d("로그", "PostingFragment - observerViewModel() called")
    }
}