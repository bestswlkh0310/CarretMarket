package com.example.carretmarket.features.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.network.model.Chatting
import com.example.carretmarket.databinding.ListChatBinding

class ChatAdapter(private val chatList: List<Chatting>): RecyclerView.Adapter<ChatAdapter.ChatHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        return ChatHolder(ListChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val chat: Chatting = chatList[curPos]
                Toast.makeText(parent.context, "${chat.name} ${chat.msg} ${chat.info}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
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