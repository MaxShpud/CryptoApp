package com.example.myapplication.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

class SplashViewModel : ViewModel() {

	private val _resultLiveData = MutableLiveData<Any>()
	val resultLiveData: LiveData<Any> = _resultLiveData

	fun waitAndGoFurther() {
		Observable.just(Any()).delay(7000, TimeUnit.MILLISECONDS).subscribe({
			_resultLiveData.postValue(it)
		}, {
			print(it.message)
		})
	}

}