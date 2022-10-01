package com.example.topmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.topmovies.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, TopMoviesFragment(), null).commit()
    }
}