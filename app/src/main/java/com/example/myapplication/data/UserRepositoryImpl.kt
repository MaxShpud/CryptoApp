package com.example.myapplication.data

import com.example.myapplication.data.converters.UserParamToUserConverter
import com.example.myapplication.data.converters.UserToUserNameConverter
import com.example.myapplication.data.storage.UserStorage
import com.example.myapplication.domain.models.UserName
import com.example.myapplication.domain.models.UserNameParam
import com.example.myapplication.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userStorage: UserStorage,
    private val userParamToUserConverter: UserParamToUserConverter,
    private val userToUserNameConverter: UserToUserNameConverter
) : UserRepository {

    override fun saveUserParam(userParam: UserNameParam): Boolean {
        return userStorage.saveUserParam(userParamToUserConverter.invoke(userParam))
    }

    override fun getUserName(): UserName {
        return userToUserNameConverter.invoke(userStorage.getUserName())
    }
}