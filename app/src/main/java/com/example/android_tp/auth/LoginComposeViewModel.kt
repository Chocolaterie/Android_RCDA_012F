package com.example.android_tp.auth

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LoginComposeViewModel : ViewModel() {

    /**
     * Une classe qui sert uniquement a stocker email/password dans un form login
     * BONUS : En plus pourra l'envoyer dans le Body de la requête API
     */
    var loginRequest = MutableStateFlow(LoginRequest());
}