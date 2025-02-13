package com.example.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        //starting the secondActivity
        binding.btnSubmit.setOnClickListener{
            val userInput = arrayOf(
                binding.fname.text.toString(),
                binding.lname.text.toString(),
                binding.dob.text.toString(),
                binding.country.text.toString()
            )
            //explicit activity
            Intent(this, thirdActivity::class.java).also {
                it.putExtra("userInput", userInput)
                startActivity(it)
            }
        }
        //implicit activity to open a browser for a url
        binding.btnBrowser.setOnClickListener {
            val url = binding.url.text.toString()
            Log.d("URL",url)
            if (url.isNotEmpty()) {
               val intent =  Intent(Intent.ACTION_VIEW, Uri.parse(url))
                // Check if there is an app that can handle this intent
                if (intent.resolveActivity(packageManager) != null) {
                    // Show chooser dialog
                    val chooser = Intent.createChooser(intent, "Open with")
                    startActivity(chooser)

                } else {

                    // Handle the case where no app can handle the intent
                    Log.e("hello", "No application can handle this request.")
                }

            }else {
                // Optionally, show a message to the user if the URL is empty
                binding.url.error = "Please enter a valid URL"
            }
        }





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}