package com.example.android_tp.compose.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_tp.R
import com.example.android_tp.ui.theme.Android_TPTheme
import com.example.android_tp.ui.theme.ENITextField
import com.example.android_tp.ui.theme.GradientButton
import com.example.android_tp.ui.theme.TemplateFormPage

class ResetPasswordComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_TPTheme {
                ResetPasswordContentPage()
            }
        }
    }
}

@Composable
fun ResetPasswordContentPage() {
    TemplateFormPage {
        Image(
            painter = painterResource(id = R.drawable.reset_password),
            contentDescription = "",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.padding(vertical = 80.dp))
        ENITextField(labelText = "Email", value = "Todo", onValueChange = {})
        GradientButton(labelText = "Send Link", modifier = Modifier.padding(top= 10.dp), onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun ResetPasswordComposeActivityPreview() {
    Android_TPTheme {
        ResetPasswordContentPage()
    }
}