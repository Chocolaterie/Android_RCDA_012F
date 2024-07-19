package com.example.android_tp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import com.example.android_tp.auth.SignUpViewModel
import com.example.android_tp.databinding.ActivityRegisterBinding

class SignUpActivity : ComponentActivity() {

    lateinit var viewBinding : ActivityRegisterBinding;
    lateinit var signUpViewModel : SignUpViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en mode DataBinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        // Initialiser/Instancier le viewmodel
        signUpViewModel = SignUpViewModel()
        // -- associer le viewmodel dans le xml
        viewBinding.signUpViewModel = signUpViewModel;

        // Quand je clique sur le bouton se connecter
        val btnSignUp = findViewById<Button>(R.id.btnSignUp);
        btnSignUp.setOnClickListener {

            // Controle de surface
            // V1 Tu creer une classe qui sert a valider
            // RegisterValidator.validate(signUpViewModel)
            // V2 Controle de surface à la mano dans le onclick
//            if (signUpViewModel.person.value!!.password != signUpViewModel.passwordConfirmation.value!!){
//                // Erreur
//            }
            // V3 Controle de surface dans Appel service web qu'on aurait développer le view model
            // signUpViewModel.validate();

            DialogHelper.showDialog(this, "Email : ${signUpViewModel.person.value!!.email}" +
                    "\nPseudo : ${signUpViewModel.person.value!!.pseudo}");

        }
    }
}