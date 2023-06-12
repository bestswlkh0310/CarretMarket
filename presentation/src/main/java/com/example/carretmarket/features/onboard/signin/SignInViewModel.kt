package com.example.carretmarket.features.onboard.signin

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.carretmarket.base.BaseViewModel
import com.example.data.model.VerifyKeyResponse
import com.example.carretmarket.util.Constant.TAG
import com.example.domain.request.NewBoardRequest
import com.example.domain.usecase.board.BoardUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val boardUseCases: BoardUseCases
): BaseViewModel() {

    private val _getVerifyKeyState = MutableSharedFlow<VerifyKeyResponse>()
    val getVerifyKeyState: SharedFlow<VerifyKeyResponse> = _getVerifyKeyState

    val id = MutableLiveData<String>()
    val pw = MutableLiveData<String>()

    fun onClickLogin() {
        Log.d(TAG, "id - ${id.value} pw - ${pw.value} - onLoginClick() called")

//        val mainIntent = Intent(context, MainActivity::class.java)
        if (pw.value == null) return
//        verifyKey = runBlocking {
//            VerifyKeyFetcher.fetch() ?: exitProcess(-1)
//        }

//        val pwEncrypted = RSA.encrypt(verifyKey.publicKey, pw.value!!)

        viewModelScope.launch {
            boardUseCases.postBoard(NewBoardRequest(
                "0612",
                "0612"
            )).collect {
                Log.d(TAG, "$it - onClickLogin() called")
            }
        }


        /*val call = RetrofitClient.loginAPI.login(
            SignInRequest(
                id.value!!,
                pwEncrypted,
                verifyKey.verificationToken
            )
        )*/
        /*call.enqueue(object : Callback<BaseResponse<TokenResponse>> {
            override fun onResponse(call: Call<BaseResponse<TokenResponse>>, response: Response<BaseResponse<TokenResponse>>) {
                if (response.code() == 200) {
                    val body = response.body()?.data
                    Session.accessToken = body?.accessToken
                    Session.refreshToken = body?.refreshToken
//                    context.startActivity(mainIntent)
                    Log.d("LoginRequest", "Logged in maybe. ${Session.accessToken} ${Session.refreshToken}")
                } else {
                    Log.d("LoginRequest", "Failed to login: ${response.code()} ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<BaseResponse<TokenResponse>>, t: Throwable) {
                Log.d("LoginRequest", "Failed to login: ${t.stackTraceToString()}")
            }
        })*/
    }


    companion object {
        const val EVENT_VERIFY_KEY = 0
    }
}