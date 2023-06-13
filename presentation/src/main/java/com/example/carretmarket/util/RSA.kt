package com.example.carretmarket.util

import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

object RSA {
    fun generateKeyPair(): KeyPair = KeyPairGenerator.getInstance("RSA").apply { initialize(2048) }.genKeyPair()
    fun encrypt(publicKey: String, message: String): String {
        val private = KeyFactory.getInstance("RSA").generatePublic(X509EncodedKeySpec(
            Base64._decrypt(
                publicKey.toByteArray()
            )
        ))
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.ENCRYPT_MODE, private)
        return Base64.encrypt(cipher.doFinal(message.toByteArray()))
    }
    fun decrypt(privateKey: String, message: String): String {
        val private = KeyFactory.getInstance("RSA").generatePrivate(PKCS8EncodedKeySpec(
            Base64._decrypt(
                privateKey.toByteArray()
            )
        ))
        val cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding")
        cipher.init(Cipher.DECRYPT_MODE, private)
        return String(cipher.doFinal(Base64._decrypt(message.toByteArray())))
    }
}