package com.example.myapplication.domain

import com.example.myapplication.domain.base.UseCase
import com.example.myapplication.domain.models.UserNameParam

class SaveUserNameUseCase : UseCase<UserNameParam, Boolean> {

    override fun execute(param: UserNameParam?): Boolean {
        return param!!.name.isNotEmpty()
    }
}