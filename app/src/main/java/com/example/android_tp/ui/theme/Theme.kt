package com.example.android_tp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

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
@Composable
fun GradientButton(modifier: Modifier, labelText: String) {
    Button(
        border = BorderStroke(3.dp, Color(0x77FFFFFF)),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(40.dp))
            .background(Color.Transparent).then(modifier), onClick = {}) {
        Box (modifier = Modifier.background(primaryGradientBrush).fillMaxWidth().padding(vertical = 15.dp),
            contentAlignment = Alignment.Center){
            Text(text = labelText)
        }
    }
}

@Composable
fun Android_TPTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}