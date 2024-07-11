package com.example.android_tp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import com.example.android_tp.auth.ResetPasswordViewModel
import com.example.android_tp.databinding.ActivityResetPasswordBinding

class ResetPasswordActivity : ComponentActivity() {

    lateinit var viewBinding: ActivityResetPasswordBinding;
    lateinit var resetPasswordViewModel: ResetPasswordViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger la vue
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_reset_password);

        // Associer le view model dans la vue
        resetPasswordViewModel = ResetPasswordViewModel();
        viewBinding.resetPasswordViewModel = resetPasswordViewModel;

        // Quand je clique sur le bouton se connecter
        viewBinding.btnSendLink.setOnClickListener {
            // afficher la popup
            DialogHelper.showDialog(this, "Email : ${resetPasswordViewModel.email.value!!}");
        }
    }
}