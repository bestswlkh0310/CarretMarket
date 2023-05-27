package com.example.carretmarket.features.onboard.post

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
    val title = MutableLiveData("asd")
    val content = MutableLiveData("")
    fun postContent() {
        Log.d(TAG, "PostingViewModel - postContent() called")
        val board = NewBoardRequest(
            title.value!!,
            content.value!!
        )
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