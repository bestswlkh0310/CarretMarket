package com.example.carretmarket.viewmodel

import androidx.lifecycle.ViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.request.NewBoardRequest
import com.example.carretmarket.network.response.BoardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputViewModel: ViewModel() {
    fun postContent(board: NewBoardRequest) {
        val call = RetrofitClient.boardAPI.postBoard(board)
        call.enqueue(object: Callback<BoardResponse> {
            override fun onResponse(call: Call<BoardResponse>, response: Response<BoardResponse>) {
                if (response.isSuccessful) {
                    // do something

                    return
                }
                val body = response.raw().body()!!.string()

            }

            override fun onFailure(call: Call<BoardResponse>, message: Throwable) {

            }
        })
    }
}