package com.example.data.repository

import com.example.data.datasource.CommentDataSource
import com.example.domain.model.Comment
import com.example.domain.repository.CommentRepository
import com.example.domain.request.NewCommentRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentDataSource: CommentDataSource
): CommentRepository {
    override fun getComments(id: Long): Flow<List<Comment>> {
        return commentDataSource.getComments(id)
    }

    override fun postComment(id: Long, postCommentRequest: NewCommentRequest): Flow<Unit> {
        return commentDataSource.postComment(id, postCommentRequest)
    }

    override fun patchComment(
        id: Long,
        commentId: Long,
        newCommentRequest: NewCommentRequest
    ): Flow<Unit> {
        return commentDataSource.patchComment(id, commentId, newCommentRequest)
    }

    override fun deleteComment(id: Long, commentId: Long): Flow<Unit> {
        return commentDataSource.deleteComment(id, commentId)
    }
}