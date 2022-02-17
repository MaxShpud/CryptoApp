package com.example.myapplication.domain.repository

import com.example.myapplication.domain.models.UserName
import com.example.myapplication.domain.models.UserNameParam

interface UserRepository {

    fun saveUserParam(userParam: UserNameParam): Boolean

    fun getUserName(): UserName
}