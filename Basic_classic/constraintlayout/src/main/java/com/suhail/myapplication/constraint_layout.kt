package com.suhail.myapplication

import com.suhail.myapplication.databinding.ActivityConstraintLayoutBinding
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class constraint_layout : AppCompatActivity() {
    //initializing the binding
    private lateinit var binding: ActivityConstraintLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // inflating by Binding
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
          setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //change to binding
//        setContentView(R.layout.activity_constraint_layout)

    //Old way to access widgets and error prone
//        val btn_submit = findViewById<Button>(R.id.btn_submit) ld way
//        btn_submit.setOnClickListener {
//             btn_submit.text = "Hi"
//            Log.d("Button", "${btn_submit.text}")
//        }

        binding.btnSubmit.setOnClickListener {
            val input = readIO(
                binding.fname.text.toString(),
                binding.lname.text.toString(),
                binding.dob.text.toString()
                ,binding.country.text.toString()
            )

            if (binding.fname.text.toString().isNotEmpty())
            {
                binding.title.text = "Hi ${binding.fname.text}"
            }
            Log.d("Submit Button", "$input" )

        }


    }
}
fun readIO(vararg userInput:String):List<String>{
    var userIO:List<String> = mutableListOf<String>()
    userIO = userInput.toList()
    return userIO

}