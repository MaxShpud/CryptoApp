package com.example.data.storage.converters

import com.example.data.storage.models.User
import com.example.domain.Converter
import com.example.domain.models.UserNameParam

class UserParamToUserConverter : Converter<UserNameParam, User> {

    override fun invoke(params: UserNameParam): User {
        return User(params.name, "")
    }
}