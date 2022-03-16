package com.example.myapplication.presentation.di

import com.example.domain.repository.usecase.GetCurrencyUseCase
import com.example.domain.repository.usecase.GetUserNameUseCase
import com.example.domain.repository.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(get())
    }

    factory<GetCurrencyUseCase> {
        GetCurrencyUseCase(get())
    }
}