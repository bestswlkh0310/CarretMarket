package com.example.carretmarket.features.community.board

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.domain.model.Board
import com.example.domain.usecase.board.BoardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
): BaseViewModel() {
    val boardData = MutableLiveData<Board>()

    fun getBoard(id: Long? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            boardUseCases.getBoard(id).collect { board ->
                boardData.postValue(board)
            }
        }
    }
}