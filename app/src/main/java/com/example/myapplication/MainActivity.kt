package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val anotherFragment = AnotherFragment.newInstance("Hello, World")
            supportFragmentManager.beginTransaction()
                .add(R.id.container, anotherFragment)
                .commit()
        }
    }

    companion object {
        const val MAIN_ACTIVITY_KEY = "MAIN_ACTIVITY_KEY"
    }
}