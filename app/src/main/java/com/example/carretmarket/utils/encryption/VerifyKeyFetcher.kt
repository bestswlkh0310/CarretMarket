package com.example.carretmarket.utils.encryption

import android.util.Log
import com.example.carretmarket.data.response.VerifyKeyResponse
import com.example.carretmarket.utils.retrofit.Retrofit
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object VerifyKeyFetcher {
    suspend fun fetch(): VerifyKeyResponse? {
        var toReturn: VerifyKeyResponse? = null
        var continuable = false
        Retrofit.verifyAPI.fetchVerifyKey().enqueue(object : Callback<VerifyKeyResponse> {
            override fun onResponse(
                call: Call<VerifyKeyResponse>,
                response: Response<VerifyKeyResponse>
            ) {
                Log.d("FetchVerifyKey", "Yes: ${response.code()}")
                if (response.code() == 200) {
                    val keyOrNull = response.body()
                    if (keyOrNull == null)
                        Log.d("FetchVerifyKey", "Failed to fetch: ${response.code()}")
                    toReturn = keyOrNull
                    continuable = true
                }
            }

            override fun onFailure(call: Call<VerifyKeyResponse>, t: Throwable) {
                Log.d("FetchVerifyKey", "Failed to fetch: ${t.stackTraceToString()}")
                continuable = true
            }
        })
        while (!continuable) {
            Log.d("FetchVerifyKey", "Yes: no")
            delay(100L)
        }
        return toReturn
    }
}