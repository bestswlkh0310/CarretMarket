package com.example.carretmarket.network

import com.example.data.service.BoardService
import com.example.data.service.LoginService
import com.example.data.service.VerifyService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val url = "https://localhost:8090/"
    private val loggingInterceptor = HttpLoggingInterceptor {
            message ->
//        Log.d(TAG, "$message - RetrofitClient() called")
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