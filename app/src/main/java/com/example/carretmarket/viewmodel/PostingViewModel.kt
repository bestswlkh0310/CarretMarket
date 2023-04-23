package com.example.carretmarket.viewmodel

import androidx.lifecycle.ViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.NewBoardRequest
import com.example.carretmarket.network.response.BoardResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostingViewModel: ViewModel() {
    fun postContent(board: NewBoardRequest) {
        val call = RetrofitClient.boardAPI.postBoard(board)
        call.enqueue(object: Callback<BaseResponse<BoardResponse>> {
            override fun onResponse(call: Call<BaseResponse<BoardResponse>>, response: Response<BaseResponse<BoardResponse>>) {
//                if (response.isSuccessful) {
//                }
//                val body = response.raw().body()!!.string()
            }
            override fun onFailure(call: Call<BaseResponse<BoardResponse>>, message: Throwable) {

            }
        })
    }
}