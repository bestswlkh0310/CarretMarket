package com.example.carretmarket.features.community

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Board
import com.example.carretmarket.databinding.ListBoardBinding
import com.example.domain.model.BoardList
import java.sql.Date
import java.sql.Timestamp

class CommunityAdapter(
    private val boardList: List<BoardList>,
    private val onClickBoard: (BoardList) -> Unit
    ): RecyclerView.Adapter<CommunityAdapter.BoardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardHolder {
        return BoardHolder(ListBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val board: BoardList = boardList[curPos]
                onClickBoard(board)
                Toast.makeText(parent.context, board.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: BoardHolder, position: Int) {
        val board = boardList[position]
        holder.title.text = board.title
        holder.time.text = Date(Timestamp(board.timestamp!!).time).toString()
    }

    override fun getItemCount(): Int = boardList.size

    class BoardHolder(binding: ListBoardBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val time = binding.tvTime
    }
}