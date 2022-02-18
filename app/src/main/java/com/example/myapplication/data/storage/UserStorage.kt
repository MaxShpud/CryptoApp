package com.example.myapplication.data.storage

import com.example.myapplication.data.storage.models.User

interface UserStorage {

    fun saveUserParam(user: User): Boolean

    fun getUserName(): User
}