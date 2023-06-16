package com.example.carretmarket.features.community.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.databinding.FragmentBoardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : BaseFragment<FragmentBoardBinding, BoardViewModel>() {

    private val args by navArgs<BoardFragmentArgs>()
    override val viewModel: BoardViewModel by viewModels()

    private lateinit var adapter: CommentAdapter

    override fun observerViewModel() {
        viewModel.boardData.observe(this) { board ->
            with(mBinding) {
                title.text = board.title
                content.text = board.content
            }
        }

        viewModel.commentsData.observe(this) { comments ->
            if (comments != null) {
                viewModel.addComments(comments)
                adapter.notifyItemRangeInserted(0, comments.size)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initBoard()
        initRecyclerView()
        return view
    }

    private fun initBoard() {
        with(viewModel) {
            boardId = args.boardId
            getBoard(boardId)
        }
    }

    private fun initRecyclerView() {
        viewModel.commentsData.value = null
        adapter = CommentAdapter(viewModel.commentList)
        with(mBinding) {
            rvComments.adapter = adapter
            rvComments.layoutManager = LinearLayoutManager(context)
        }
        viewModel.getComments(args.boardId)
    }
}