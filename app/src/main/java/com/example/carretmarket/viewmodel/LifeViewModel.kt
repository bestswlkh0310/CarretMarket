package com.example.carretmarket.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.model.Life
import com.example.carretmarket.network.response.BoardListResponse
import com.example.carretmarket.network.response.BoardResponse
import com.example.carretmarket.util.AdapterManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LifeViewModel: ViewModel() {
    val TAG: String = "로그"
    var itemList: MutableList<Life> = arrayListOf()

    fun addItems(items: MutableList<Life>) {
        AdapterManager.addItems(itemList, items)
    }

    fun getItem(id: Long? = null): BoardResponse? {
        var board: BoardResponse? = null
        val call = RetrofitClient.boardAPI.getBoardById(id)
        call.enqueue(object: Callback<BaseResponse<BoardResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<BoardResponse>>,
                response: Response<BaseResponse<BoardResponse>>
            ) {
                if (response.isSuccessful) {
                    board = response.body()!!.data
                }
            }
            override fun onFailure(call: Call<BaseResponse<BoardResponse>>, t: Throwable) {
            }
        })
        return board
    }

    fun getItems(timestamp: Long? = null): Map<String, String>? {
        val call = RetrofitClient.boardAPI.getBoards(timestamp)
        var boards: Map<String, String>? = null
        call.enqueue(object: Callback<BaseResponse<BoardListResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<BoardListResponse>>,
                response: Response<BaseResponse<BoardListResponse>>
            ) {
                if (response.code() == 200) {
                    boards = response.body()?.data?.boards
                } else {
                    Log.d(TAG, "HomeViewModel() - ${response.message()} called")
                }
            }

            override fun onFailure(call: Call<BaseResponse<BoardListResponse>>, t: Throwable) {

            }
        })
        return boards
    }

    fun reloadItem(timestamp: Long? = null) {
        AdapterManager.clearItem(itemList)
        for ((id, title) in getItems(timestamp)?.entries!!) {
            AdapterManager.addItem(itemList, Life(title, getItem(id.toLong())?.timestamp, id.toLong()))
        }
//        AdapterManager.addItems(itemList, getItems(timestamp))
    }
}