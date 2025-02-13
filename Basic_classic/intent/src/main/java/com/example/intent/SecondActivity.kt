package com.example.intent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity(){
    lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding =  ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn2activity.setOnClickListener {
            finish()
        }
    }
}