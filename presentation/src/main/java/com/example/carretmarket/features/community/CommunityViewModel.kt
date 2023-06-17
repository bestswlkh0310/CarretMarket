package com.example.carretmarket.features.community

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.carretmarket.util.AdapterManager
import com.example.domain.model.BoardList
import com.example.domain.usecase.board.BoardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommunityViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
) : BaseViewModel() {
    val boardsData = MutableLiveData<List<BoardList>>()
    var boardList: MutableList<BoardList> = arrayListOf()

    fun onClickPost() { viewEvent(EVENT_ON_CLICK_POST) }
    fun onClickFloatingBar() { viewEvent(EVENT_ON_CLICK_FLAOTING_BAR) }

    fun addBoards(boards: List<BoardList>) {
        AdapterManager.addItems(boardList, boards.map { it })
    }

    fun getBoards(timestamp: Long? = null) {
        viewModelScope.launch(Dispatchers.IO) {
            boardUseCases.getBoards(timestamp).collect { boards ->
                boardsData.postValue(boards)
            }
        }
    }

    fun reloadBoard() {
        AdapterManager.clearItem(boardList)
    }
    
    companion object {
        const val EVENT_ON_CLICK_POST = 0
        const val EVENT_ON_CLICK_FLAOTING_BAR = 1
    }
}