package com.example.carretmarket.features.community.board

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.util.AdapterManager
import com.example.domain.model.Board
import com.example.domain.model.Comment
import com.example.domain.request.NewCommentRequest
import com.example.domain.usecase.board.BoardUseCases
import com.example.domain.usecase.comment.CommentUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases,
    private val commentUseCases: CommentUseCases
): BaseViewModel() {
    val boardData = MutableLiveData<Board>()
    val commentsData = MutableLiveData<List<Comment>>()
    val comment = MutableLiveData<String>()

    val commentList: MutableList<Comment> = arrayListOf()
    var boardId: Long? = null

    fun addComments(comments: List<Comment>) {
        AdapterManager.addItems(commentList, comments)
    }

    fun getBoard(id: Long? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            boardUseCases.getBoard(id).collect { board ->
                boardData.postValue(board)
            }
        }
    }

    fun getComments(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            commentUseCases.getComments(id).collect { comments ->
                commentsData.postValue(comments)
            }
        }
    }

    fun postComment() {
        Log.d("로그", "postComment: ${comment.value!!}")
        viewModelScope.launch(Dispatchers.IO) {
            commentUseCases.postComment(
                id = boardId!!,
                newCommentRequest =  NewCommentRequest(comment.value!!)
            ).collect {}
        }
    }
}