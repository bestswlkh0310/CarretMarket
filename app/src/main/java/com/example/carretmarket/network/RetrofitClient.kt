package com.example.carretmarket.network

import com.example.carretmarket.network.service.BoardService
import com.example.carretmarket.network.service.LoginService
import com.example.carretmarket.network.service.VerifyService
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object RetrofitClient {
    private const val url = "https://jombi.dev:2096"

    var server: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
    var verifyAPI: VerifyService = server.create(VerifyService::class.java)
    var loginAPI: LoginService = server.create(LoginService::class.java)
    var boardAPI: BoardService = server.create(BoardService::class.java)
}