package com.example.myapplication.data.storage

import com.example.myapplication.domain.models.UserName
import com.example.myapplication.domain.models.UserNameParam

interface UserStorage {

    fun saveUserParam(userParam: UserNameParam): Boolean

    fun getUserName(): UserName
}