package com.example.carretmarket.features.community.post

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentPostingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostingFragment : BaseFragment<FragmentPostingBinding, PostingViewModel>() {
    override val viewModel: PostingViewModel by viewModels()


    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {
                PostingViewModel.EVENT_ON_CLICK_UPLOAD -> findNavController().popBackStack()
            }
        }
    }
}