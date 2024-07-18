package com.example.android_tp.compose.auth

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_tp.R
import com.example.android_tp.auth.LoginComposeViewModel
import com.example.android_tp.ui.theme.Android_TPTheme
import com.example.android_tp.ui.theme.ENITextField
import com.example.android_tp.ui.theme.GradientButton
import com.example.android_tp.ui.theme.GradientOutlinedButton
import com.example.android_tp.ui.theme.TemplateFormPage

class LoginComposeActivity : ComponentActivity() {

    // Déclarer mon view model dans l'activity
    lateinit var loginComposeViewModel: LoginComposeViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancier le view model
        loginComposeViewModel = LoginComposeViewModel();

        enableEdgeToEdge()
        setContent {
            Android_TPTheme {
                LoginContentPage(loginComposeViewModel)
            }
        }
    }
}

@Composable
fun LoginContentPage(loginComposeViewModel: LoginComposeViewModel) {
    val loginRequest by loginComposeViewModel.loginRequest.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.mobile_background),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .padding(40.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.padding(top = 40.dp))
                Image(
                    painter = painterResource(id = R.drawable.profile_user),
                    contentDescription = "",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = "Please be careful when you enter credentials in the login page",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    modifier = Modifier.padding(top = 40.dp)
                )
                Spacer(modifier = Modifier.padding(vertical = 40.dp))
                ENITextField(value = loginRequest.email, onValueChange = {
                    loginComposeViewModel.loginRequest.value =
                        loginComposeViewModel.loginRequest.value.copy(email = it)
                }, labelText = "Email")
                ENITextField(value = loginRequest.password,
                    onValueChange = {
                        loginComposeViewModel.loginRequest.value =
                            loginComposeViewModel.loginRequest.value.copy(password = it)
                    }, labelText = "Password"
                )
                GradientButton(
                    labelText = "Login",
                    modifier = Modifier.padding(top = 10.dp),
                    onClick = {
                        Log.i(
                            "TP",
                            "Email : ${loginComposeViewModel.loginRequest.value.email} & Password : ${loginComposeViewModel.loginRequest.value.password}"
                        )
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginComposeActivityPreview() {
    Android_TPTheme {
        LoginContentPage(LoginComposeViewModel())
    }
}