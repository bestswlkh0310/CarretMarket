package com.example.carretmarket.features.community.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.databinding.ListCommentBinding
import com.example.domain.model.Comment
import java.sql.Date
import java.sql.Timestamp

class CommentAdapter(private val commentList: List<Comment>): RecyclerView.Adapter<CommentAdapter.CommentHolder>() {
    inner class CommentHolder(binding: ListCommentBinding): RecyclerView.ViewHolder(binding.root) {
        val nickname = binding.nickname
        val content = binding.content
        val timestamp = binding.timestamp
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentHolder {
        return CommentHolder(ListCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {

        }
    }

    override fun onBindViewHolder(holder: CommentHolder, position: Int) {
        val comment = commentList[position]
        with(holder) {
            nickname.text = "nickName"
            content.text = comment.content
            timestamp.text = Date(Timestamp(comment.timestamp).time).toString()
        }
    }
    override fun getItemCount(): Int = commentList.size
}
