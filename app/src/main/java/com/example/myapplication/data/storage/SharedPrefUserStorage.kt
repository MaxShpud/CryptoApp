package com.example.myapplication.data.storage

import android.content.Context
import androidx.core.content.edit
import com.example.myapplication.domain.models.UserName
import com.example.myapplication.domain.models.UserNameParam

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUserParam(userParam: UserNameParam): Boolean {
        sharedPreferences.edit { putString(FIRST_NAME_KEY, userParam.name) }
        return true
    }

    override fun getUserName(): UserName {
        val firstName = sharedPreferences.getString(FIRST_NAME_KEY, EMPTY_STRING) ?: EMPTY_STRING
        val secondName =
            sharedPreferences.getString(SECOND_NAME_KEY, DEFAULT_VALUE) ?: DEFAULT_VALUE
        return UserName(
            firstName = firstName,
            secondName = secondName
        )
    }

    companion object {
        private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
        private const val FIRST_NAME_KEY = "FIRST_NAME_KEY"
        private const val SECOND_NAME_KEY = "SECOND_NAME_KEY"
        private const val EMPTY_STRING = ""
        private const val DEFAULT_VALUE = "default value"
    }
}