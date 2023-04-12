package com.example.carretmarket.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carretmarket.network.model.Life
import com.example.carretmarket.databinding.FragmentLifeBinding
import com.example.carretmarket.view.adapter.LifeAdapter

class LifeFragment: Fragment() {
    private val binding: FragmentLifeBinding by lazy { FragmentLifeBinding.inflate(layoutInflater) }
    companion object {
        const val TAG: String = "로그"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(HomeFragment.TAG, "LifeFragment - onCreateView() called")

        val rv = binding.rvLife
        val lifeList = listOf(
            Life("title", "하이", "asd"),
            Life("ㅁㄴㅇ", "ㄹㅇㄹㅇㅁㄹㅁ", "helo"),
            Life("ㅁㄴㅇ", "ㅇㅇㅇ", "asdasdsa"),
            Life("ㅁㄴㅇ", "ㅂㅈㄷㅂㅈㄷ", "ad"),
            Life("ㅇㅇㅇㅇ", "ㅇㅇㄹㅇㄹ", "wqer"),
        )

        // Adapter, LayoutManager 연결
        val adapter = LifeAdapter(lifeList)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())
//        rv.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

//        return inflater.inflate(R.layout.fragment_home, container, false)
        return binding.root
    }
}