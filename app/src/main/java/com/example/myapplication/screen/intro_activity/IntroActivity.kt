package com.example.myapplication.screen.intro_activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityIntroBinding
import com.example.myapplication.screen.main_activity.MainActivity
import com.example.myapplication.screen.signup_activity.SignupActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class IntroActivity : AppCompatActivity() {
    private var _binding : ActivityIntroBinding?=null
    private val binding get() = _binding!!
    lateinit var auth :FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityIntroBinding.inflate(layoutInflater)
         setContentView(binding.root)
        auth = Firebase.auth

        binding.startButton.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            val intent2 = Intent(this, MainActivity::class.java)
            if(auth.currentUser!=null) {
                startActivity(intent2)
             }
            else{
                startActivity(intent)
            }
            finish()
        }

    }
}