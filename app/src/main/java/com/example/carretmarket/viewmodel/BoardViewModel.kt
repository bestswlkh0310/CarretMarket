package com.example.carretmarket.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.model.Board
import com.example.carretmarket.network.model.Item
import com.example.carretmarket.network.response.BoardListResponse
import com.example.carretmarket.network.response.BoardResponse
import com.example.carretmarket.util.AdapterManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoardViewModel: ViewModel() {
    val TAG: String = "로그"
    var itemList: MutableList<Board> = arrayListOf()

    /**
     * adapter에 게시글들 넣기
     */
    fun addItems(items: MutableList<Board>) {
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

    fun getItems(timestamp: Long? = null): MutableList<Board> {
        val call = RetrofitClient.boardAPI.getBoards(timestamp)
        val boards: MutableList<Board> = arrayListOf()
        call.enqueue(object: Callback<BaseResponse<List<BoardListResponse>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<BoardListResponse>>>,
                response: Response<BaseResponse<List<BoardListResponse>>>
            ) {
                if (response.code() == 200) {
                    response.body()!!.data.forEach {
                        boards.add(
                            Board(
                                it.id,
                                it.timestamp,
                                it.title
                            )
                        )
                    }
                } else {
                    Log.d(TAG, "HomeViewModel() - ${response.message()} called")
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<BoardListResponse>>>, t: Throwable) {

            }
        })
        return boards
    }

    fun reloadItem() {
        Log.d(TAG, "BoardViewModel - reloadItem() called")
        AdapterManager.clearItem(itemList)
        AdapterManager.addItems(itemList, getItems())
    }
}