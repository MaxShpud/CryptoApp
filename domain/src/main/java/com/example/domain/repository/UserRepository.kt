package com.example.domain.repository

import com.example.domain.models.UserName
import com.example.domain.models.UserNameParam

interface UserRepository {

    fun saveUserParam(userParam: UserNameParam): Boolean

    fun getUserName(): UserName
}