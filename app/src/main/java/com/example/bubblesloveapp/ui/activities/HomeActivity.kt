package com.example.bubblesloveapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.bubblesloveapp.R
import com.example.bubblesloveapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.activityHomeToolbar.title = ""
        setSupportActionBar(binding.activityHomeToolbar)
    }

    override fun onStart() {
        super.onStart()
        binding.activityHomeToolbarImage.setOnClickListener(){
            Log.d("HOLA", "Hola")
        }

        val navController = findNavController(R.id.nav_host_home_fragment)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment ,
            R.id.lugaresFragment ,
            R.id.citaFragment ,
            R.id.ProfileFragment
        ))
        binding.activityHomeBottomNavigation.setupWithNavController(navController)
        binding.activityHomeToolbar.setupWithNavController(navController, appBarConfiguration)

    }
}