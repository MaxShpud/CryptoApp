package com.example.myapplication.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.textview.MaterialTextView

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)

        val text = findViewById<MaterialTextView>(R.id.secondText)

        val textTwo = findViewById<MaterialTextView>(R.id.secondTextTwo)

        val intent = Intent(this, MainActivity::class.java)

        text.setOnClickListener {
            startActivity(intent)
        }

        textTwo.setOnClickListener {
            startActivity(Intent(this, AuthActivity::class.java))
            textTwo.text = "text"
        }

        intent.extras?.let {
            text.text = it.get(MainActivity.MAIN_ACTIVITY_KEY).toString()
        }
    }
}