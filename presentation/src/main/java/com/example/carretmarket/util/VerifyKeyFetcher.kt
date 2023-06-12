package com.example.carretmarket.util

import android.util.Log
import com.example.data.model.VerifyKeyResponse
import com.example.data.base.BaseResponse
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object VerifyKeyFetcher {
    suspend fun fetch(): VerifyKeyResponse? {
        var toReturn: VerifyKeyResponse? = null
        var continuable = false
        /*RetrofitClient.verifyAPI.fetchVerifyKey().enqueue(object : Callback<BaseResponse<VerifyKeyResponse>> {
            override fun onResponse(
                call: Call<BaseResponse<VerifyKeyResponse>>,
                response: Response<BaseResponse<VerifyKeyResponse>>
            ) {
                Log.d("FetchVerifyKey", "Yes: ${response.code()}")
                if (response.code() == 200) {
                    val keyOrNull = response.body()?.data
                    if (keyOrNull == null)
                        Log.d("FetchVerifyKey", "Failed to fetch: ${response.code()}")
                    toReturn = keyOrNull
                    continuable = true
                } else {
                    Log.d("FetchVerifyKey", "VerifyKeyFetcher - onResponse() called")
                    continuable = true
                }
            }

            override fun onFailure(call: Call<BaseResponse<VerifyKeyResponse>>, t: Throwable) {
                Log.d("FetchVerifyKey", "Failed to fetch: ${t.stackTraceToString()}")
                continuable = true
            }
        })*/

        while (!continuable) {
            Log.d("FetchVerifyKey", "Yes: no")
            delay(100L)
        }

        return toReturn
    }
}