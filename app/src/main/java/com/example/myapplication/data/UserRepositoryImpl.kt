package com.example.myapplication.data

import com.example.myapplication.data.storage.UserStorage
import com.example.myapplication.domain.models.UserName
import com.example.myapplication.domain.models.UserNameParam
import com.example.myapplication.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveUserParam(userParam: UserNameParam): Boolean {
        return userStorage.saveUserParam(userParam)
    }

    override fun getUserName(): UserName {
        return userStorage.getUserName()
    }
}