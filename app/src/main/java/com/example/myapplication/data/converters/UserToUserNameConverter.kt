package com.example.myapplication.data.converters

import com.example.myapplication.data.storage.models.User
import com.example.myapplication.domain.Converter
import com.example.myapplication.domain.models.UserName

class UserToUserNameConverter : Converter<User, UserName> {

    override fun invoke(params: User): UserName {
        return UserName(params.firstName, params.secondName)
    }
}