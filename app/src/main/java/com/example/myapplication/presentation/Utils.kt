package com.example.myapplication.presentation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.TypedValue
import kotlin.math.roundToInt

fun Activity.showMainActivity() {
	this.startActivity(Intent(this, MainActivity::class.java))
}

fun Context.dp2pxFloat(dp: Float): Float =
	TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)

fun Context.dp2px(dp: Float): Int = dp2pxFloat(dp).roundToInt()