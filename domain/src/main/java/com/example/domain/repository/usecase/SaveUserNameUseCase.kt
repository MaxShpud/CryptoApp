package com.example.domain.repository.usecase

import com.example.domain.base.UseCase
import com.example.domain.models.UserNameParam
import com.example.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) :
	UseCase<UserNameParam, Boolean> {

	override fun execute(param: UserNameParam?): Boolean {
		return userRepository.saveUserParam(param!!)
	}
}