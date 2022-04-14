package com.example.myapplication.presentation.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.presentation.showMainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

	private val viewModel by viewModel<SplashViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.splash_activity)
		subscribeLiveData()
		viewModel.waitAndGoFurther()
	}

	private fun subscribeLiveData() {
		viewModel.resultLiveData.observe(this) {
			showMainActivity()
			finish()
		}
	}
}