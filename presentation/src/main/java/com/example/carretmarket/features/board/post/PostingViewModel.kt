package com.example.carretmarket.features.board.post

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.NewBoardRequest
import com.example.carretmarket.network.response.BoardResponse
import com.example.carretmarket.util.Constant.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostingViewModel: BaseViewModel() {
    val title = MutableLiveData("")
    val content = MutableLiveData("")
    fun postContent() {
        val board = NewBoardRequest(
            title.value!!,
            content.value!!
        )
        Log.d("로그", "${board} - postContent() called")
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