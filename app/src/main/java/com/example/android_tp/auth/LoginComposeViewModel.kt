package com.example.android_tp.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_tp.compose.movie.ListMovieComposeActivity
import com.example.demofullapiandroid.AlertDialogData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.math.log

class LoginComposeViewModel(var activity: Activity?) : ViewModel() {

    /**
     * Une classe qui sert uniquement a stocker email/password dans un form login
     * BONUS : En plus pourra l'envoyer dans le Body de la requête API
     */
    var loginRequest = MutableStateFlow(LoginRequest(email = "isaac@gmail.com", password = "password"));
    var alertDialogData = MutableStateFlow(AlertDialogData());

    fun callAuthApi(){
        // TODO : Afficher boite de chargement
        // lancer dans une tâche async (coroutine)
        viewModelScope.launch {

            // Appel l'api auth en envoyant les données dans loginRequest
            val apiResponse = AuthService.AuthApi.authService.auth(loginRequest.value);

            // TODO : Cacher la boite de chargement

            // Connexion reussi
            if (apiResponse.code == "203"){
                // Stocker le token
                AuthContext.token = apiResponse.data!!;

                // Afficher popup success
                AlertDialogData.showAlert(alertDialogData, "Information", apiResponse.message, onClose = {
                    // ouvrir la page movies
                    val intent = Intent(activity, ListMovieComposeActivity::class.java);
                    activity!!.startActivity(intent);
                });
            }
            else {
                // Afficher popup success
                AlertDialogData.showAlert(alertDialogData, "Erreur", apiResponse.message, onClose = {});
            }
        }
    }
}