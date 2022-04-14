package com.example.myapplication.presentation

import android.app.Activity
import android.content.Intent

fun Activity.showMainActivity() {
	this.startActivity(Intent(this, MainActivity::class.java))
}