package com.example.domain.usecase.comment

import com.example.domain.model.Comment
import com.example.domain.repository.CommentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetComments @Inject constructor(
    private val commentRepository: CommentRepository
) {
    operator fun invoke(id: Long): Flow<List<Comment>> {
        return commentRepository.getComments(id)
    }
}