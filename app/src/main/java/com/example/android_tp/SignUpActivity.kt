package com.example.android_tp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.core.view.children

class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger le rendu XML
        setContentView(R.layout.activity_register)

        // Quand je clique sur le bouton se connecter
        val btnSignUp = findViewById<Button>(R.id.btnSignUp);
        btnSignUp.setOnClickListener {
            // récupérer l'email
            val email = findViewById<EditText>(R.id.edtEmail).text.toString();
            val pseudo = findViewById<EditText>(R.id.edtPseudo).text.toString();

            // For each TODO:  demain
//            val parent= findViewById<LinearLayout>(R.id.layoutForm);
//            parent.children
            // afficher la popup
            DialogHelper.showDialog(this, "Email : ${email}" +
                    "\nPseudo : ${pseudo}");
        }
    }
}