package com.example.carretmarket.features.board

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.domain.model.Board
import com.example.carretmarket.util.AdapterManager
import com.example.carretmarket.util.Constant.TAG
import com.example.domain.model.BoardList
import com.example.domain.model.toBoard
import com.example.domain.usecase.board.BoardUseCases
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BoardViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
) : BaseViewModel() {
    private val _getBoardState = MutableSharedFlow<Board>()
    val getBoardState: SharedFlow<Board> = _getBoardState

    private val _getBoardsState = MutableSharedFlow<List<BoardList>>()
    val getBoardsState: SharedFlow<List<BoardList>> = _getBoardsState

    var boardList: MutableList<Board> = arrayListOf()

    fun onClickPost() { viewEvent(EVENT_ON_CLICK_POST) }
    fun onClickFloatingBar() { viewEvent(EVENT_ON_CLICK_FLAOTING_BAR) }

    fun addBoards(boards: List<BoardList>) {
        AdapterManager.addItems(boardList, boards.map { it.toBoard() })
    }

    fun getBoard(id: Long? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            boardUseCases.getBoard(id).collect {board ->
                _getBoardState.emit(board)
            }
        }
    }

    fun getBoards(timestamp: Long? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            boardUseCases.getBoards(timestamp).collect { boards ->
                _getBoardsState.emit(boards)
            }
        }
    }

    fun reloadBoard() {
        Log.d(TAG, "BoardViewModel - reloadBoard() called")
        AdapterManager.clearItem(boardList)
//        itemList.removeFirst()
        show()
    }
    private fun show() {
        Log.d(TAG, "BoardViewModel - show() called")
        for (i in boardList) {
            Log.d(TAG, "${i.title} - show()")
        }
    }

    companion object {
        const val EVENT_ON_CLICK_POST = 0
        const val EVENT_ON_CLICK_FLAOTING_BAR = 1
    }
}