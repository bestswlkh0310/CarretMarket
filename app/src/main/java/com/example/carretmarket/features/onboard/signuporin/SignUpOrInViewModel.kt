package com.example.carretmarket.features.onboard.signuporin

import com.example.carretmarket.base.BaseViewModel

class SignUpOrInViewModel : BaseViewModel() {
    fun onClickSignUp() {
        viewEvent(EVENT_ON_CLICK_SIGN_UP)
    }

    fun onClickSignIn() {
        viewEvent(EVENT_ON_CLICK_SIGN_IN)
    }

    companion object {
        const val EVENT_ON_CLICK_SIGN_UP = 0
        const val EVENT_ON_CLICK_SIGN_IN = 1
    }
}