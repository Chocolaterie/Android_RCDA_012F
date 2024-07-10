package com.example.android_tp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_tp.ui.theme.Android_TPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login);

        // Quand je clique sur s'inscrire
        val tvSignUp = findViewById<TextView>(R.id.tvSignUp);
        tvSignUp.setOnClickListener {
            // Ouvrir la page inscription (SignUpActivity)
            val intent = Intent(this, SignUpActivity::class.java);
            startActivity(intent);
        }

        // Quand je clique sur oublié mon mot de passe
        val tvForgetPassword = findViewById<TextView>(R.id.tvForgetPassword);
        tvForgetPassword.setOnClickListener {
            // Ouvrir la page reset password (ResetPasswordActivity)
            val intent = Intent(this, ResetPasswordActivity::class.java);
            startActivity(intent);
        }

    }
}
