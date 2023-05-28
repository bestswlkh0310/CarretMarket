package com.example.carretmarket.features.board

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.network.RetrofitClient
import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.model.Board
import com.example.carretmarket.network.response.BoardListResponse
import com.example.carretmarket.network.response.BoardResponse
import com.example.carretmarket.util.AdapterManager
import com.example.carretmarket.util.Constant.TAG
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BoardViewModel: BaseViewModel() {
    var boardList: MutableList<Board> = arrayListOf()

    /**
     * @param boards
     * add Boards in itemList
     */
    fun addBoards(boards: List<Board>) {
        AdapterManager.addItems(boardList, boards)
    }

    /**
     * @param id
     * @return board: BoardResponse
     */
    fun getBoard(id: Long? = null): BoardResponse? {
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
            override fun onFailure(call: Call<BaseResponse<BoardResponse>>, t: Throwable) {}
        })
        return board
    }

    /**
     * @param timestamp
     * @return boards: List<Board>
     */
    fun getBoards(timestamp: Long? = null): List<Board> {
        Log.d(TAG, "BoardViewModel - getBoards() called")
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

    /**
     * clear boardList
     */
    fun reloadBoard() {
        Log.d(TAG, "BoardViewModel - reloadBoard() called")
        AdapterManager.clearItem(boardList)
//        itemList.removeFirst()
        show()
    }
    private fun show() {
        Log.d(TAG, "BoardViewModel - show() called")
        for (i in boardList) {
            Log.d(TAG, "${i.title} - show()")
        }
    }
}