package com.example.android_tp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.android_tp.auth.ResetPasswordViewModel
import com.example.android_tp.databinding.ActivityLoginBinding
import com.example.android_tp.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : ComponentActivity() {

    lateinit var viewBinding: ActivityResetPasswordBinding;
    lateinit var resetPasswordViewModel: ResetPasswordViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue en mode DataBinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password);

        // Initialiser le viewmodel
        resetPasswordViewModel = ResetPasswordViewModel()
        // -- associer le viewmodel dans le xml
        viewBinding.resetPasswordViewModel = resetPasswordViewModel;

        // Quand je clique sur le bouton se connecter
        viewBinding.btnSendLink.setOnClickListener {

            // Attention la valeur d'un MutableLiveData c'es tdans .value
            // value est nullable donc !! pour forcer à prendre une valeur non null
            // si c'est null ca crash donc les devs sont censé(e)
            // avoir au moins alimenter une fois la valeur de l'email (dans l'EditText)
            val email = resetPasswordViewModel.email.value!!;

            // afficher la popup
            DialogHelper.showDialog(this, "Email : ${email}");
        }
    }
}