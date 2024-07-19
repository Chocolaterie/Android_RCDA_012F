package com.example.android_tp

import android.app.AlertDialog
import android.content.Intent
import android.database.DatabaseUtils
import android.os.Bundle
import android.widget.Button
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
import androidx.databinding.DataBindingUtil
import com.example.android_tp.auth.LoginViewModel
import com.example.android_tp.databinding.ActivityLoginBinding
import com.example.android_tp.ui.theme.Android_TPTheme

class MainActivity : ComponentActivity() {

    lateinit var viewBinding : ActivityLoginBinding;
    lateinit var loginViewModel: LoginViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en version data binding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        // Instancier un viewmodel par défaut
        loginViewModel = LoginViewModel();
        // -- associer/le lier dans le xml
        viewBinding.loginViewModel = loginViewModel;

        // Quand je clique sur le bouton se connecter
        viewBinding.btnLogin.setOnClickListener {
            // afficher la popup
            DialogHelper.showDialog(this, "Vous êtes connecté(e) avec succès");
        }

        // Quand je clique sur s'inscrire
        viewBinding.tvSignUp.setOnClickListener {
            // Ouvrir la page inscription (SignUpActivity)
            val intent = Intent(this, SignUpActivity::class.java);
            startActivity(intent);
        }

        // Quand je clique sur oublié mon mot de passe
        viewBinding.tvForgetPassword.setOnClickListener {
            // Ouvrir la page reset password (ResetPasswordActivity)
            val intent = Intent(this, ResetPasswordActivity::class.java);
            startActivity(intent);
        }

    }
}
