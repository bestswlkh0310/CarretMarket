package com.example.carretmarket.view.MainFragment.RecyclerViewAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.data.Item
import com.example.carretmarket.databinding.ListItemBinding

class ItemAdapter(private val itemList: List<Item>): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemHolder {
        return ItemHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)).apply {
            itemView.setOnClickListener {
                val curPos: Int = adapterPosition
                val item: Item = itemList[curPos]
                Toast.makeText(parent.context, "${item.title} ${item.price}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemHolder, position: Int) {
        val item = itemList[position]
        holder.title.text = item.title
        holder.price.text = item.price.toString()
    }

    override fun getItemCount(): Int = itemList.size

    inner class ItemHolder(binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        val title = binding.tvTitle
        val price = binding.tvPrice
    }
}