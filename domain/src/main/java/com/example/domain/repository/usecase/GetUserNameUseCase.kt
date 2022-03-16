package com.example.domain.repository.usecase

import com.example.domain.base.UseCase
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) : UseCase<Unit, UserName> {

    override suspend fun execute(param: Unit?): UserName {
        return userRepository.getUserName()
    }
}