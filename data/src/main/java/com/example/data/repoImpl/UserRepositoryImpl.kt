package com.example.data.repoImpl

import com.example.data.storage.UserStorage
import com.example.data.storage.converters.UserParamToUserConverter
import com.example.data.storage.converters.UserToUserNameConverter
import com.example.domain.models.UserName
import com.example.domain.models.UserNameParam
import com.example.domain.repository.UserRepository

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