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
            // V1 : Correction attendu
            val email = findViewById<EditText>(R.id.edtEmail).text.toString();
            val pseudo = findViewById<EditText>(R.id.edtPseudo).text.toString();
            // etc..
            DialogHelper.showDialog(this, "Email : ${email}" +
                    "\nPseudo : ${pseudo}");

            // BONUS
            // Version for each
            /*
            val parent = findViewById<LinearLayout>(R.id.layoutForm);
            var message = "";
            for (i in 0 until parent.childCount){
                // récuperer le composant par son index
                val view = parent.getChildAt(i);

                // tester le cast en toute sécurité et en plus dans le if le view devient un type EditText
                if (view is EditText) {
                    message += "${view.text.toString()}\n";
                }
            }
            // afficher la popup
            DialogHelper.showDialog(this, message);
            */
        }
    }
}