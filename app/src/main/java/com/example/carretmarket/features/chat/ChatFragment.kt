package com.example.carretmarket.features.chat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.network.model.Chatting
import com.example.carretmarket.databinding.FragmentChattingBinding
import com.example.carretmarket.features.home.HomeFragment
import com.example.carretmarket.features.chat.ChatAdapter

class ChatFragment: Fragment() {
    private val binding: FragmentChattingBinding by lazy { FragmentChattingBinding.inflate(layoutInflater) }
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
            Chatting("title", "하이", "asd"),
            Chatting("ㅁㄴㅇ", "ㄹㅇㄹㅇㅁㄹㅁ", "helo"),
            Chatting("ㅁㄴㅇ", "ㅇㅇㅇ", "asdasdsa"),
            Chatting("ㅁㄴㅇ", "ㅂㅈㄷㅂㅈㄷ", "ad"),
            Chatting("ㅇㅇㅇㅇ", "ㅇㅇㄹㅇㄹ", "wqer"),
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