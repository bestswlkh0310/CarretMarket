package com.example.carretmarket.util

import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import javax.crypto.Cipher

object RSA {
    fun encrypt(publicKey: String, message: String): String {
        val private = KeyFactory.getInstance("RSA").generatePublic(X509EncodedKeySpec(Base64.getDecoder().decode(publicKey.toByteArray())))
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, private)
        return Base64.getEncoder().encodeToString(cipher.doFinal(message.toByteArray()))
    }
}