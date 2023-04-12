package com.example.carretmarket.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.network.model.Item
import com.example.carretmarket.databinding.FragmentHomeBinding
import com.example.carretmarket.view.adapter.ItemAdapter

class HomeFragment: Fragment() {
    private val binding: FragmentHomeBinding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "HomeFragment - onCreateView() called")

        val rv = binding.rvItems
        val itemList = listOf(
            Item("title", 9999999),
            Item("title", 9999999),
            Item("title", 9999999),
            Item("title", 9999999),
            Item("title", 9999999),
        )

        // Adapter, LayoutManager 연결
        val adapter = ItemAdapter(itemList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

//        return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }
}