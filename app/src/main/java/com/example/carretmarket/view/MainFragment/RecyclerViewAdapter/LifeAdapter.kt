package com.example.carretmarket.view.MainFragment.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.data.Life
import com.example.carretmarket.databinding.ListLifeBinding

class LifeAdapter(private val chatList: List<Life>): RecyclerView.Adapter<LifeAdapter.LifeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeAdapter.LifeHolder {
        return LifeHolder(ListLifeBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val chat: Life = chatList[curPos]
                Toast.makeText(parent.context, "${chat.title} ${chat.msg} ${chat.info}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: LifeAdapter.LifeHolder, position: Int) {
        val chat = chatList[position]
        holder.title.text = chat.title
        holder.msg.text = chat.msg
        holder.info.text = chat.info
    }

    override fun getItemCount(): Int = chatList.size

    inner class LifeHolder(binding: ListLifeBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val msg = binding.tvMsg
        val info = binding.tvInfo
    }
}