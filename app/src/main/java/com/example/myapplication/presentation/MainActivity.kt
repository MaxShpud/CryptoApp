package com.example.myapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView:BottomNavigationView=findViewById(R.id.nav_view)

        val navController=findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeScreenFragment,
                R.id.walletScreenFragment,
                R.id.exchangerScreenFragment,
                R.id.chatScreenFragment,
                R.id.settingsScreenFragment
            )
        )
        setupActionBarWithNavController(navController ,appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    companion object {
        const val MAIN_ACTIVITY_KEY = "MAIN_ACTIVITY_KEY"
    }
}