package com.example.finalbs_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    fun performAction(view: View) {
        val nextButton: ImageButton = findViewById(R.id.circular_button)
        nextButton.setOnClickListener {
            val intent = Intent(this@SplashScreen, HomeActivity::class.java)
            startActivity(intent)
        }

    }
}