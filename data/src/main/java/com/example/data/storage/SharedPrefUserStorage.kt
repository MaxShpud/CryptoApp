package com.example.data.storage

import android.content.Context
import androidx.core.content.edit
import com.example.data.storage.models.User

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUserParam(user: User): Boolean {
        sharedPreferences.edit { putString(FIRST_NAME_KEY, user.firstName) }
        sharedPreferences.edit { putString(SECOND_NAME_KEY, user.secondName) }
        return true
    }

    override fun getUserName(): User {
        val firstName = sharedPreferences.getString(FIRST_NAME_KEY, DEFAULT_VALUE) ?: DEFAULT_VALUE
        val secondName =
            sharedPreferences.getString(SECOND_NAME_KEY, DEFAULT_VALUE) ?: DEFAULT_VALUE
        return User(
            firstName = firstName,
            secondName = secondName
        )
    }

    companion object {
        private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
        private const val FIRST_NAME_KEY = "FIRST_NAME_KEY"
        private const val SECOND_NAME_KEY = "SECOND_NAME_KEY"
        private const val DEFAULT_VALUE = "default value"
    }
}