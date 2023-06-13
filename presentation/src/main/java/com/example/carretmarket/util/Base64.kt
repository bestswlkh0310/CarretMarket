package com.example.carretmarket.util

object Base64 {
    private val enc = java.util.Base64.getEncoder()
    private val dec = java.util.Base64.getDecoder()
    fun encrypt(a: ByteArray): String {
        return enc.encodeToString(a)
    }
    fun encrypt(string: String): String {
        return enc.encodeToString(string.toByteArray())
    }
    fun _encrypt(a: ByteArray): ByteArray {
        return enc.encode(a)
    }
    fun decrypt(a: ByteArray): String {
        return String(dec.decode(a))
    }
    fun decrypt(string: String): String {
        return String(dec.decode(string))
    }
    fun _decrypt(a: ByteArray): ByteArray {
        return dec.decode(a)
    }
}