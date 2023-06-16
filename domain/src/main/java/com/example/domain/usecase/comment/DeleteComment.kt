package com.example.domain.usecase.comment

import com.example.domain.repository.CommentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DeleteComment @Inject constructor(
    private val commentRepository: CommentRepository
) {
    operator fun invoke(id: Long, commentId: Long): Flow<Unit> {
        return commentRepository.deleteComment(id, commentId)
    }
}