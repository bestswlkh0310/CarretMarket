package com.example.carretmarket.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.network.model.Life
import com.example.carretmarket.databinding.ListLifeBinding

class LifeAdapter(private val chatList: List<Life>): RecyclerView.Adapter<LifeAdapter.LifeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LifeHolder {
        return LifeHolder(ListLifeBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val life: Life = chatList[curPos]
                Toast.makeText(parent.context, "${life.title} ${life.timestamp} ${life.id}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: LifeHolder, position: Int) {
        val life = chatList[position]
        holder.title.text = life.title
//        holder.info.text = life.
    }

    override fun getItemCount(): Int = chatList.size

    inner class LifeHolder(binding: ListLifeBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val info = binding.tvInfo
    }
}