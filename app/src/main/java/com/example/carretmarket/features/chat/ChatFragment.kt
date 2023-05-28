package com.example.carretmarket.features.chat

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.base.BaseFragment
import com.example.carretmarket.network.model.Chatting
import com.example.carretmarket.databinding.FragmentChattingBinding
import com.example.carretmarket.util.Constant.TAG

class ChatFragment : BaseFragment<FragmentChattingBinding, ChatViewModel>() {
    override val viewModel: ChatViewModel by viewModels()

    override fun observerViewModel() {
        Log.d(TAG, "ChatFragment - onCreateView() called")

        val chatList = listOf(
            Chatting("title", "하이", "asd"),
            Chatting("ㅁㄴㅇ", "ㄹㅇㄹㅇㅁㄹㅁ", "helo"),
            Chatting("ㅁㄴㅇ", "ㅇㅇㅇ", "asdasdsa"),
            Chatting("ㅁㄴㅇ", "ㅂㅈㄷㅂㅈㄷ", "ad"),
            Chatting("ㅇㅇㅇㅇ", "ㅇㅇㄹㅇㄹ", "wqer"),
        )

        // Adapter, LayoutManager 연결
        val adapter = ChatAdapter(chatList)
        with(mBinding.rvChats) {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}