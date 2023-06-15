package com.example.carretmarket.features.community.board

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : BaseFragment<FragmentBoardBinding, BoardViewModel>() {

    private val boardId by navArgs<BoardFragmentArgs>()
    override val viewModel: BoardViewModel by viewModels()

    override fun observerViewModel() {
        viewModel.boardData.observe(this) { board ->
            with(mBinding) {
                title.text = board.title
                content.text = board.content
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getBoard(boardId.boardId)
    }
}