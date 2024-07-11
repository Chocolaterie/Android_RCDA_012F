package com.example.android_tp.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    var person = MutableLiveData<Person>(Person());
    var passwordConfirmation = "";
}