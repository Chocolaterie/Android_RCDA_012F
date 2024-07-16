package com.example.android_tp.compose.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_tp.ui.theme.Android_TPTheme

class LoginComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android_TPTheme {
                LoginContentPage()
            }
        }
    }
}

@Composable
fun ENITextField(labelText: String) {
    TextField(
        value = "",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        onValueChange = { },
        label = { Text(text = labelText) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0x22000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
        shape = RoundedCornerShape(40.dp)
    )
}

val primaryGradientBrush = Brush.horizontalGradient(
    listOf(Color(0xFFFEB9F2), Color(0xFFA1C1FE))
)

@Composable
fun GradientOutlinedButton() {
    OutlinedButton(
        shape = RoundedCornerShape(40.dp),
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(40.dp))
            .background(primaryGradientBrush), onClick = {}) {
        Text(text = "Login")
    }
}

@Composable
fun GradientButton() {
    Button(
        border = BorderStroke(3.dp, Color(0x77FFFFFF)),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(40.dp))
            .background(Color.Transparent), onClick = {}) {
        Box (modifier = Modifier.background(primaryGradientBrush).fillMaxWidth().padding(vertical = 10.dp),
            contentAlignment = Alignment.Center){
            Text(text = "Login")
        }
    }
}

@Composable
fun LoginContentPage() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding.calculateTopPadding() + 40.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Login", fontSize = 40.sp, modifier = Modifier.padding(top = 80.dp))
            Spacer(modifier = Modifier.padding(vertical = 80.dp))
            ENITextField(labelText = "Email")
            ENITextField(labelText = "Password")
            GradientOutlinedButton()
            GradientButton()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginComposeActivityPreview() {
    Android_TPTheme {
        LoginContentPage()
    }
}