package com.example.myapplication.domain

import com.example.myapplication.domain.base.UseCase
import com.example.myapplication.domain.models.UserName

class GetUserNameUseCase : UseCase<Unit, UserName> {

    override fun execute(param: Unit?): UserName {
        return UserName("Egor","Gutko")
    }
}