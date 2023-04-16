package com.example.carretmarket.network.service

import com.example.carretmarket.network.base.BaseResponse
import com.example.carretmarket.network.request.NewBoardRequest
import com.example.carretmarket.network.response.BoardListResponse
import com.example.carretmarket.network.response.BoardResponse
import retrofit2.Call
import retrofit2.http.*

interface BoardService {
    @GET("api/v1/board/{id}")
    fun getBoardById(@Path("id") id: Long?): Call<BaseResponse<BoardResponse>>

    @GET("api/v1/board/list")
    fun getBoards(@Query("timestamp") timestamp: Long?): Call<BaseResponse<List<BoardListResponse>>>

    @PATCH("api/v1/board/{id}")
    fun patchBoard(@Path("id") id: Long): Call<BaseResponse<Unit>>

    @DELETE("api/v1/board/{id}")
    fun delBoard(@Path("id") id: Long): Call<BaseResponse<Unit>>

    @POST("api/v1/board/new")
    fun postBoard(@Body newBoardRequest: NewBoardRequest): Call<BaseResponse<BoardResponse>>

}