package com.example.carretmarket.view.MainFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carretmarket.R
import com.example.carretmarket.data.Chating
import com.example.carretmarket.data.Item
import com.example.carretmarket.databinding.FragmentChatBinding
import com.example.carretmarket.databinding.FragmentHomeBinding
import com.example.carretmarket.view.MainFragment.RecyclerViewAdapter.ChatAdapter
import com.example.carretmarket.view.MainFragment.RecyclerViewAdapter.ItemAdapter

class ChatFragment: Fragment() {
    private val binding: FragmentChatBinding by lazy { FragmentChatBinding.inflate(layoutInflater) }
    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(HomeFragment.TAG, "ChatFragment - onCreateView() called")

        val rv = binding.rvChats
        val chatList = listOf(
            Chating("title", "하이", "asd"),
            Chating("ㅁㄴㅇ", "ㄹㅇㄹㅇㅁㄹㅁ", "helo"),
            Chating("ㅁㄴㅇ", "ㅇㅇㅇ", "asdasdsa"),
            Chating("ㅁㄴㅇ", "ㅂㅈㄷㅂㅈㄷ", "ad"),
            Chating("ㅇㅇㅇㅇ", "ㅇㅇㄹㅇㄹ", "wqer"),
        )

        // Adapter, LayoutManager 연결
        val adapter = ChatAdapter(chatList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
//        rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

//        return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }
}