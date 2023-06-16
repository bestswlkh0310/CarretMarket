package com.example.data.service

import com.example.data.base.BaseResponse
import com.example.data.model.CommentResponse
import com.example.domain.request.NewCommentRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentService {

    @GET("api/v1/board/{id}/comment")
    suspend fun getComments(
        @Path("id") id: Long
    ): BaseResponse<List<CommentResponse>>

    @POST("api/v1/board/{id}/comment")
    suspend fun postComment(
        @Path("id") id: Long,
        @Body postCommentRequest: NewCommentRequest
    ): BaseResponse<Unit>

    @PATCH("api/v1/board/{id}/comment/{commentId}")
    suspend fun patchComment(
        @Path("id") id: Long,
        @Path("commentId") commentId: Long,
        @Body newCommentRequest: NewCommentRequest
    ): BaseResponse<Unit>

    @DELETE("api/v1/board/{id}/comment/{commentId}")
    suspend fun deleteComment(
        @Path("id") id: Long,
        @Path("commentId") commentId: Long,
    ): BaseResponse<Unit>
}