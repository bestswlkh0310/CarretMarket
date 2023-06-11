package com.example.data.base

data class BaseResponse<T>(
    val status: Int,
    val data: T
)