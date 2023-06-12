package com.example.data.service

import com.example.data.base.BaseResponse
import com.example.data.model.BoardListResponse
import com.example.data.model.BoardResponse
import com.example.domain.request.NewBoardRequest
import com.example.domain.request.PatchBoardRequest
import retrofit2.Call
import retrofit2.http.*

interface BoardService {
    @GET("api/v1/board/{id}")
    suspend fun getBoardById(
        @Path("id") id: Long?
    ): BaseResponse<BoardResponse>

    @GET("api/v1/board/list")
    suspend fun getBoards(
        @Query("timestamp") timestamp: Long?
    ): BaseResponse<List<BoardListResponse>>

    @PATCH("api/v1/board/{id}")
    suspend fun patchBoard(
        @Path("id") id: Long,
        @Body newBoardRequest: PatchBoardRequest
    ): BaseResponse<Unit>

    @DELETE("api/v1/board/{id}")
    suspend fun deleteBoard(
        @Path("id") id: Long
    ): BaseResponse<Unit>

    @POST("api/v1/board/new")
    suspend fun postBoard(
        @Body newBoardRequest: NewBoardRequest
    ): BaseResponse<BoardResponse>
}