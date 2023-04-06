package com.example.carretmarket.utils.retrofit

import com.example.carretmarket.utils.retrofit.impl.LoginAPI
import com.example.carretmarket.utils.retrofit.impl.VerifyAPI
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object Retrofit {
    private const val url = "https://jombi.dev:2096"

    var server: Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()
    var verifyAPI: VerifyAPI = server.create(VerifyAPI::class.java)
    var loginAPI: LoginAPI = server.create(LoginAPI::class.java)
}