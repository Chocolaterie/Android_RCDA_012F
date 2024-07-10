package com.example.android_tp

import android.os.Bundle
import androidx.activity.ComponentActivity

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger le rendu XML
        setContentView(R.layout.activity_register)
    }
}