package com.example.intent

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityThirdBinding
class thirdActivity : AppCompatActivity() {

    lateinit var binding: ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //receiving the array from main activity
        val userInput = intent.getStringArrayExtra("userInput")
        if (userInput != null){
            binding.txt3Activity.text =userInput.joinToString(", ") // Join with a comma and space
            Log.d("user" , userInput.joinToString(", "))

        }else{
            binding.txt3Activity.text = " No user input received."
            Log.d("user", "No user input received.")
        }

    }
}