package com.example.myapplication.presentation.di

import com.example.myapplication.presentation.main.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<MainFragmentViewModel> {
        MainFragmentViewModel(get(), get())
    }
}