package com.example.data.storage.converters

import com.example.data.storage.models.User
import com.example.domain.Converter
import com.example.domain.models.UserName

class UserToUserNameConverter : Converter<User, UserName> {

    override fun invoke(params: User): UserName {
        return UserName(params.firstName, params.secondName)
    }
}