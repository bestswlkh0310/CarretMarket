package com.example.carretmarket.features.community.board.patch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentPatchingBinding
import com.example.carretmarket.features.community.board.BoardFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PatchFragment : BaseFragment<FragmentPatchingBinding, PatchViewModel>() {
    override val viewModel: PatchViewModel by viewModels()

    private val args by navArgs<BoardFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initBoard()
        return view
    }

    private fun initBoard() {
        viewModel.boardId = args.boardId
    }

    override fun observerViewModel() {
        bindingViewEvent {  event ->
            when (event) {
                PatchViewModel.EVENT_ON_CLICK_UPLOAD -> findNavController().popBackStack()
            }
        }
    }
}