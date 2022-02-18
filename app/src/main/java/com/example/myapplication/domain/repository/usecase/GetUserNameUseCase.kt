package com.example.myapplication.domain.repository.usecase

import com.example.myapplication.domain.base.UseCase
import com.example.myapplication.domain.models.UserName
import com.example.myapplication.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) : UseCase<Unit, UserName> {

    override fun execute(param: Unit?): UserName {
        return userRepository.getUserName()
    }
}