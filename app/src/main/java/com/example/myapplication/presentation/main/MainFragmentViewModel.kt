package com.example.myapplication.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.UserNameParam
import com.example.domain.repository.usecase.GetCurrencyUseCase
import com.example.domain.repository.usecase.GetUserNameUseCase
import com.example.domain.repository.usecase.SaveUserNameUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainFragmentViewModel(
	private val getUserNameUseCase: GetUserNameUseCase,
	private val saveUserNameUseCase: SaveUserNameUseCase,
	private val getCurrencyUseCase: GetCurrencyUseCase
) : ViewModel() {

	private val _resultLiveData = MutableLiveData<String>()
	val resultLiveData: LiveData<String> = _resultLiveData

	init {
		println("MainFragmentViewModel created")

		getCurrencyUseCase.execute()
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe({
				println(it)
			}, {
				println(it.message)
			})
	}

	fun save(userName: String) {
		viewModelScope.launch {
			val result = saveUserNameUseCase.execute(UserNameParam(userName))
			_resultLiveData.value = result.toString()
		}
	}

	fun load() {
		viewModelScope.launch {
			val userName = getUserNameUseCase.execute()
			_resultLiveData.value = userName.firstName
		}
	}

	override fun onCleared() {
		println("MainFragmentViewModel cleared")
		super.onCleared()
	}
}