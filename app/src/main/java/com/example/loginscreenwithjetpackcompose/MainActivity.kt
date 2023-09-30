package com.example.loginscreenwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginscreenwithjetpackcompose.ui.theme.LoginScreenWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenWithJetpackComposeTheme {
                // Jetpack compose Practice - building a modern login screen with Jetpack Compose
                Surface(modifier = Modifier.fillMaxSize()) {
                    LoginScreen()
                }
            }
        }
    }
}

@Preview(name = "yzan", showBackground = true)
@Composable
fun loginScreen() {
    LoginScreen()
}
//jlvbsdjbvdbvsjdbvjksdbvsdj
//dvlsbdvobslvbsdlvbsdl