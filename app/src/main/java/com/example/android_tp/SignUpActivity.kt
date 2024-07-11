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

    lateinit var viewBinding: ActivityRegisterBinding;
    lateinit var signUpViewModel: SignUpViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Charger le rendu XML en mode DataBinding
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        // Associer le view model
        signUpViewModel = SignUpViewModel();
        viewBinding.signUpViewModel = signUpViewModel;

        // Quand je clique sur le bouton se connecter
        viewBinding.btnSignUp.setOnClickListener {
            DialogHelper.showDialog(
                this, "Email : ${signUpViewModel.person.value!!.email}" +
                        "\nPseudo : ${signUpViewModel.person.value!!.pseudo}" +
                        "\nPassword : ${signUpViewModel.person.value!!.password}" +
                        "\nCity Code : ${signUpViewModel.person.value!!.cityCode}" +
                        "\nCity : ${signUpViewModel.person.value!!.city}"
            );
        }
    }
}