package com.example.carretmarket.features.board.post

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.carretmarket.R
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentPostingBinding
import com.example.carretmarket.features.board.BoardFragment

class PostingFragment : BaseFragment<FragmentPostingBinding, PostingViewModel>() {
    override val viewModel: PostingViewModel by viewModels()
    lateinit var callback: OnBackPressedCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callback = requireActivity().onBackPressedDispatcher.addCallback {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fl_main, BoardFragment())
            }
        }
    }

    override fun onStop() {
        super.onStop()
        callback.remove()
    }

    override fun observerViewModel() {}
}