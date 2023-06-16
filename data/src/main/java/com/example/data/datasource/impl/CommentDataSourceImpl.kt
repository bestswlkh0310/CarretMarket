package com.example.data.datasource.impl

import com.example.data.datasource.CommentDataSource
import com.example.data.mapper.toEntity
import com.example.data.service.CommentService
import com.example.domain.model.Comment
import com.example.domain.request.NewCommentRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CommentDataSourceImpl @Inject constructor(
    private val commentService: CommentService
): CommentDataSource {
    override fun getComments(id: Long): Flow<List<Comment>> {
        return flow {
            emit(commentService.getComments(id).data.map { it.toEntity() })
        }
    }

    override fun postComment(id: Long, newCommentRequest: NewCommentRequest): Flow<Unit> {
        return flow {
            emit(commentService.postComment(id, newCommentRequest).data)
        }
    }

    override fun patchComment(
        id: Long,
        commentId: Long,
        newCommentRequest: NewCommentRequest
    ): Flow<Unit> {
        return flow {
            emit(commentService.patchComment(id, commentId, newCommentRequest).data)
        }
    }

    override fun deleteComment(id: Long, commentId: Long): Flow<Unit> {
        return flow {
            emit(commentService.deleteComment(id, commentId).data)
        }
    }
}