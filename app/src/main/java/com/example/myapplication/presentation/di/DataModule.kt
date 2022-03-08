package com.example.myapplication.presentation.di

import com.example.data.UserRepositoryImpl
import com.example.data.storage.SharedPrefUserStorage
import com.example.data.storage.UserStorage
import com.example.data.storage.converters.UserParamToUserConverter
import com.example.data.storage.converters.UserToUserNameConverter
import com.example.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(get())
    }

    single<UserRepository> {
        UserRepositoryImpl(
            get(),
            get(),
            get()
        )
    }

    factory {
        UserParamToUserConverter()
    }

    factory {
        UserToUserNameConverter()
    }
}