package com.example.carretmarket.features.onboard.post

import android.util.Log
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentPostingBinding

class PostingFragment : BaseFragment<FragmentPostingBinding, PostingViewModel>() {
    override val viewModel: PostingViewModel by viewModels()
    override val TAG = PostingFragment::class.java.simpleName
    override val layoutRes = R.layout.fragment_posting

    override fun observerViewModel() {
        binding.vm = PostingViewModel()
        viewModel.title.observe(this) {
            binding.tvPost.text = it
        }
        Log.d("로그", "PostingFragment - observerViewModel() called")
    }
}