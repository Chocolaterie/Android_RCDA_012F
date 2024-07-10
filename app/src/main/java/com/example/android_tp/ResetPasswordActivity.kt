package com.example.android_tp

import android.os.Bundle
import androidx.activity.ComponentActivity

class ResetPasswordActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue
        setContentView(R.layout.activity_reset_password);
    }
}