package com.example.myapplication.data.converters

import com.example.myapplication.data.storage.models.User
import com.example.myapplication.domain.Converter
import com.example.myapplication.domain.models.UserNameParam

class UserParamToUserConverter : Converter<UserNameParam, User> {

    override fun invoke(params: UserNameParam): User {
        return User(params.name, "")
    }
}