package com.example.carretmarket.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {
    protected val _viewEvent = MutableLiveData<Any>()
    val viewEvent: LiveData<Any>
        get() = _viewEvent

    fun viewEvent(content: Any) {
        _viewEvent.value = content
    }

}