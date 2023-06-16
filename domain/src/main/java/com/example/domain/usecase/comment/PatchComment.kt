package com.example.domain.usecase.comment

import com.example.domain.repository.CommentRepository
import com.example.domain.request.NewCommentRequest
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PatchComment @Inject constructor(
    private val commentRepository: CommentRepository
) {
    operator fun invoke(id: Long, commentId: Long, newCommentRequest: NewCommentRequest): Flow<Unit> {
        return commentRepository.patchComment(id, commentId, newCommentRequest)
    }
}