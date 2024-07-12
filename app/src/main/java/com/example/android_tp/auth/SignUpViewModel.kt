package com.example.android_tp.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    // la personne qui va contenir les données d'inscription
    var person = MutableLiveData<Person>(Person());

    var passwordConfirmation = MutableLiveData<String>();
}