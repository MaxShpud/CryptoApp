package com.example.myapplication.presentation.di

import com.example.myapplication.presentation.main.MainFragmentViewModel
import com.example.myapplication.presentation.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

	viewModel<SplashViewModel> {
		SplashViewModel()
	}

	viewModel<MainFragmentViewModel> {
		MainFragmentViewModel(get(), get(), get())
	}
}