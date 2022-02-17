package com.example.myapplication.domain

import com.example.myapplication.domain.base.UseCase
import com.example.myapplication.domain.models.UserNameParam
import com.example.myapplication.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) :
    UseCase<UserNameParam, Boolean> {

    override fun execute(param: UserNameParam?): Boolean {
        return userRepository.saveUserParam(param!!)
    }
}