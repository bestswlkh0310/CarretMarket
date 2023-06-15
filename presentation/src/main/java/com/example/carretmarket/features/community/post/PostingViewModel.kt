package com.example.carretmarket.features.community.post

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.domain.request.NewBoardRequest
import com.example.domain.usecase.board.BoardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostingViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
) : BaseViewModel() {
    val title = MutableLiveData("")
    val content = MutableLiveData("")

    fun postContent() {
        viewEvent(EVENT_ON_CLICK_UPLOAD)
        viewModelScope.launch {
            boardUseCases.postBoard(
                NewBoardRequest(
                    title.value!!,
                    content.value!!
                )
            )
        }
    }

    companion object {
        const val EVENT_ON_CLICK_UPLOAD = 0
    }
}