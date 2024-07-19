package com.example.demofullapiandroid

import kotlinx.coroutines.flow.MutableStateFlow

data class AlertDialogData(
    var showDialog: Boolean = false,
    var title: String = "",
    var message: String = ""
) {

    fun show(title: String, message: String){
        this.title = title;
        this.message = message;
    }

    companion object {
        /**
         * Fonction utilitaire pour :
         * - Changer le titre et le message d'une AlertDialogData qui est observable
         * - Changer le value du state (donc l'observable) pour notifier le changement
         * - Donc changer le showDialog a true en notifiant les changements
         */
        fun showAlert(alertDialogData: MutableStateFlow<AlertDialogData>,
                      title: String, message: String){
            alertDialogData.value.show(title, message);
            alertDialogData.value = alertDialogData.value.copy(showDialog = true)
        }

        /**
         * Fonction utilitaire pour :
         * - Changer le value du state (donc l'observable) pour notifier le changement
         * - Donc changer le showDialog a false en notifiant les changements
         */
        fun dismissAlert(alertDialogData: MutableStateFlow<AlertDialogData>){
            alertDialogData.value = alertDialogData.value.copy(showDialog = false)
        }
    }
}