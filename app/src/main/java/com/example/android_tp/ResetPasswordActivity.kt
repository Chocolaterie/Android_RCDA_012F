package com.example.android_tp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class ResetPasswordActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue
        setContentView(R.layout.activity_reset_password);

        // Quand je clique sur le bouton se connecter
        val btnSendLink = findViewById<Button>(R.id.btnSendLink);
        btnSendLink.setOnClickListener {
            // récupérer l'email
            val email = findViewById<EditText>(R.id.edtEmail).text.toString();

            // afficher la popup
            DialogHelper.showDialog(this, "Email : ${email}");
        }
    }
}