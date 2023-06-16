package com.example.domain.usecase.comment

data class CommentUseCases (
    val getComments: GetComments,
    val postComment: PostComment,
    val patchComment: PatchComment,
    val deleteComment: DeleteComment
)
