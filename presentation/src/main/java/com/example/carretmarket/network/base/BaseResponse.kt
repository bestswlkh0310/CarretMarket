package com.example.carretmarket.network.base

data class BaseResponse<T>(
    val status: Int,
    val data: T
)