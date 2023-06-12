package com.example.carretmarket.features.board.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.domain.request.NewBoardRequest
import com.example.domain.usecase.board.BoardUseCases
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PostingViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
) : BaseViewModel() {
    val title = MutableLiveData("")
    val content = MutableLiveData("")

    private val _postBoardState = MutableSharedFlow<Unit>()

    fun postContent() {
        viewModelScope.launch {
            boardUseCases.postBoard(
                NewBoardRequest(
                    title.value!!,
                    content.value!!
                )
            )
        }
    }
}