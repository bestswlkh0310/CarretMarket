package com.example.carretmarket.view.MainFragment.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.data.Chating
import com.example.carretmarket.databinding.ListChatBinding

class ChatAdapter(private val chatList: List<Chating>): RecyclerView.Adapter<ChatAdapter.ChatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ChatHolder {
        return ChatHolder(ListChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val chat: Chating = chatList[curPos]
                Toast.makeText(parent.context, "${chat.name} ${chat.msg} ${chat.info}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ChatAdapter.ChatHolder, position: Int) {
        val chat = chatList[position]
        holder.name.text = chat.name
        holder.msg.text = chat.msg
        holder.info.text = chat.info
    }

    override fun getItemCount(): Int = chatList.size

    inner class ChatHolder(binding: ListChatBinding): RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvName
        val msg = binding.tvMsg
        val info = binding.tvInfo
    }
}