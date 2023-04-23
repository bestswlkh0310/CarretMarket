package com.example.carretmarket.network

import android.util.Log
import com.example.carretmarket.network.service.BoardService
import com.example.carretmarket.network.service.LoginService
import com.example.carretmarket.network.service.VerifyService
import com.example.carretmarket.util.Constant.TAG
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val url = "https://jombi.dev:2096/"
    private val loggingInterceptor = HttpLoggingInterceptor {
            message ->
        Log.d(TAG, "$message - RetrofitClient() called")
    }.setLevel(Level.BODY)

    private val client = OkHttpClient.Builder().addInterceptor(loggingInterceptor)


    var server: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client.build())
        .build()
    var verifyAPI: VerifyService = server.create(VerifyService::class.java)
    var loginAPI: LoginService = server.create(LoginService::class.java)
    var boardAPI: BoardService = server.create(BoardService::class.java)
}