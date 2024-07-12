package com.example.android_tp.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    // Valeur exploitable dans le viewmodel
    // Dans le cadre de Login : Les identifiants stockés dans la classe Person
    var person = MutableLiveData<Person>(Person())
}