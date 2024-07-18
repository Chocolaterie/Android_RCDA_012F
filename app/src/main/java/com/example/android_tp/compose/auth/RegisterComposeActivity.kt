package com.example.android_tp.compose.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_tp.R
import com.example.android_tp.ui.theme.Android_TPTheme
import com.example.android_tp.ui.theme.ENITextField
import com.example.android_tp.ui.theme.GradientButton
import com.example.android_tp.ui.theme.TemplateFormPage

class RegisterComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_TPTheme {
                RegisterContentPage()
            }
        }
    }
}

@Composable
fun RegisterContentPage() {
    TemplateFormPage {
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Image(
            painter = painterResource(id = R.drawable.register),
            contentDescription = "",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        ENITextField(labelText = "Pseudo", value = "Todo", onValueChange = {})
        ENITextField(labelText = "Email", value = "Todo", onValueChange = {})
        ENITextField(labelText = "Password", value = "Todo", onValueChange = {})
        ENITextField(labelText = "Password Confirmation", value = "Todo", onValueChange = {})
        ENITextField(labelText = "City", value = "Todo", onValueChange = {})
        ENITextField(labelText = "City Code", value = "Todo", onValueChange = {})
        ENITextField(labelText = "Phone", value = "Todo", onValueChange = {})
        GradientButton(labelText = "Sign Up", modifier = Modifier.padding(top = 10.dp), onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterComposeActivityPreview() {
    Android_TPTheme {
        RegisterContentPage()
    }
}