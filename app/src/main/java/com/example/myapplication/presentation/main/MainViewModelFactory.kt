package com.example.myapplication.presentation.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.converters.UserParamToUserConverter
import com.example.data.storage.converters.UserToUserNameConverter
import com.example.domain.repository.usecase.GetUserNameUseCase
import com.example.domain.repository.usecase.SaveUserNameUseCase

class MainViewModelFactory(context: Context) : ViewModelProvider.Factory {

    private val userStorage by lazy { SharedPrefUserStorage(context) }
    private val userRepository by lazy {
        UserRepositoryImpl(
            userStorage,
            UserParamToUserConverter(),
            UserToUserNameConverter()
        )
    }

    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainFragmentViewModel(getUserNameUseCase, saveUserNameUseCase) as T
    }
}