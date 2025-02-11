package com.suhail.basic_classic

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Created")

        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        println("Started")
    }

    override fun onResume() {
        super.onResume()
        println("Resumed")

    }

    override fun onPause() {
        super.onPause()
        println("Paused")
    }

    override fun onStop() {
        super.onStop()
        println("Stop")

    }

    override fun onRestart() {
        super.onRestart()
        println("Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("destroyed")

    }

}