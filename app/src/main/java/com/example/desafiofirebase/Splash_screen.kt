package com.example.desafiofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.desafiofirebase.databinding.ActivityMainBinding
import com.example.desafiofirebase.databinding.ActivitySplashScreenBinding

class Splash_screen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this@Splash_screen, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}