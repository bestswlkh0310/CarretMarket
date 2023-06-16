package com.example.domain.repository

import com.example.domain.model.Comment
import com.example.domain.request.NewCommentRequest
import kotlinx.coroutines.flow.Flow

interface CommentRepository {
    fun getComments(
        id: Long
    ): Flow<List<Comment>>

    fun postComment(
        id: Long,
        postCommentRequest: NewCommentRequest
    ): Flow<Unit>


    fun patchComment(
        id: Long,
        commentId: Long,
        newCommentRequest: NewCommentRequest
    ): Flow<Unit>


    fun deleteComment(
        id: Long,
        commentId: Long,
    ): Flow<Unit>
}