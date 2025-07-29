package com.goodstuff.goodstuff

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.goodstuff.goodstuff.gui.activities.HomePage
import com.google.firebase.FirebaseApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        FirebaseApp.initializeApp(this)


        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val intent: Intent = Intent(this, HomePage::class.java)
            startActivity(intent)

        }, 2000)
    }
}