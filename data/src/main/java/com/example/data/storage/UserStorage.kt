package com.example.data.storage

import com.example.data.storage.models.User

interface UserStorage {

    fun saveUserParam(user: User): Boolean

    fun getUserName(): User
}