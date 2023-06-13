package com.example.data.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(CARRET_MARKET_APP, Context.MODE_PRIVATE)

    var autoLogin: Boolean
        get() = prefs.getBoolean(AUTO_LOGIN_KEY, false)
        set(value) = prefs.edit().putBoolean(AUTO_LOGIN_KEY, value).apply()

    var accessToken: String
        get() = prefs.getString(ACCESS_TOKEN, "").toString()
        set(value) = prefs.edit().putString(ACCESS_TOKEN, value).apply()

    var refreshToken: String
        get() = prefs.getString(REFRESH_TOKEN, "").toString()
        set(value) = prefs.edit().putString(REFRESH_TOKEN, value).apply()

    var verificationToken: String
        get() = prefs.getString(VERIFICATION_TOKEN, "").toString()
        set(value) = prefs.edit().putString(VERIFICATION_TOKEN, value).apply()

    fun deleteToken() {
        prefs.edit().remove(ACCESS_TOKEN).apply()
        prefs.edit().remove(REFRESH_TOKEN).apply()
        prefs.edit().remove(VERIFICATION_TOKEN).apply()
    }

    companion object {
        const val CARRET_MARKET_APP = "CARRET_MARKET_APP"
        const val AUTO_LOGIN_KEY = "AUTO_LOGIN_KEY"
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
        const val REFRESH_TOKEN = "REFRESH_TOKEN"
        const val VERIFICATION_TOKEN = "VERIFICATION_TOKEN"
    }
}