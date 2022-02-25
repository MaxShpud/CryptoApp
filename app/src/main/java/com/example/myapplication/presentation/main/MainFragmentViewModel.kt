package com.example.myapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.models.UserNameParam
import com.example.domain.repository.usecase.GetUserNameUseCase
import com.example.domain.repository.usecase.SaveUserNameUseCase

class MainFragmentViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val _resultLiveData = MutableLiveData<String>()
    val resultLiveData: LiveData<String> = _resultLiveData

    init {
        println("MainFragmentViewModel created")
    }

    fun save(userName: String) {
        val result = saveUserNameUseCase.execute(UserNameParam(userName))
        _resultLiveData.value = result.toString()
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        _resultLiveData.value = userName.firstName
    }

    override fun onCleared() {
        println("MainFragmentViewModel cleared")
        super.onCleared()
    }
}