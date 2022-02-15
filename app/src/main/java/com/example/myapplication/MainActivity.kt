package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)

        val intent = Intent(this, AuthActivity::class.java)
        intent.putExtra(MAIN_ACTIVITY_KEY, 30)

        text.setOnClickListener {
            startActivity(intent)
        }
    }

    companion object {
        const val MAIN_ACTIVITY_KEY = "MAIN_ACTIVITY_KEY"
    }
}