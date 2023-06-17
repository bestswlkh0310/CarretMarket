package com.example.carretmarket.features.community.board.patch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.domain.request.PatchBoardRequest
import com.example.domain.usecase.board.BoardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatchViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
) : BaseViewModel() {
    val title = MutableLiveData("")
    val content = MutableLiveData("")

    var boardId: Long? = null

    fun patchBoard() {
        viewEvent(EVENT_ON_CLICK_UPLOAD)
        viewModelScope.launch(Dispatchers.IO) {
            boardUseCases.patchBoard(
                boardId!!,
                PatchBoardRequest(
                    title.value!!,
                    content.value!!
                )
            ).collect {}
        }
    }

    companion object {
        const val EVENT_ON_CLICK_UPLOAD = 0
    }
}