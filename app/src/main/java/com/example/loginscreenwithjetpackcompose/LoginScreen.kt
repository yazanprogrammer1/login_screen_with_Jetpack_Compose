package com.example.loginscreenwithjetpackcompose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreenwithjetpackcompose.ui.theme.Black
import com.example.loginscreenwithjetpackcompose.ui.theme.BlueGray
import com.example.loginscreenwithjetpackcompose.ui.theme.LightBlueWhite
import com.example.loginscreenwithjetpackcompose.ui.theme.focusedTextField
import com.example.loginscreenwithjetpackcompose.ui.theme.unfocusedTextField

@Preview(name = "yzan", showBackground = true)
@Composable
fun LoginScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            topSection()
            Spacer(modifier = Modifier.height(36.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            ) {
                TextFieldLoginScreen("Email", "")
                Spacer(modifier = Modifier.height(15.dp))
                TextFieldLoginScreen("Password", "Forgot?")
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(size = 4.dp)
                ) {
                    Text(
                        text = "Log in",
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Or continue with",
                        style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF647488))
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        socialMediaLogIn(
                            icon = R.drawable.google,
                            text = "Google",
                            modifier = Modifier.weight(1f)
                        ) {}
                        Spacer(modifier = Modifier.width(20.dp))
                        socialMediaLogIn(
                            icon = R.drawable.facebook,
                            text = "Facebook",
                            modifier = Modifier.weight(1f)
                        ) {}
                    }
                }
            }
        }
    }
}

@Composable
private fun socialMediaLogIn(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    text: String,
    onClick: () -> Unit,
) {
    Row(modifier = modifier
        .clip(RoundedCornerShape(4.dp))
        .socialMedia()
        .clickable { onClick }
        .height(40.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "",
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = text, style = MaterialTheme.typography.labelMedium.copy(Color(0xFF647488)))
    }
}

fun Modifier.socialMedia(): Modifier = composed {
    if (isSystemInDarkTheme()) {
        background(Color.Transparent).border(
            width = 1.dp, color = BlueGray, shape = RoundedCornerShape(4.dp)
        )
    } else {
        background(LightBlueWhite)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextFieldLoginScreen(label: String, trailing: String) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(), label = {
        Text(
            text = label, style = MaterialTheme.typography.labelMedium, color = uiColor
        )
    }, colors = TextFieldDefaults.textFieldColors(
        unfocusedIndicatorColor = MaterialTheme.colorScheme.unfocusedTextField,
        focusedIndicatorColor = MaterialTheme.colorScheme.focusedTextField
    ), trailingIcon = {
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = trailing,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                color = uiColor
            )
        }
    })
}

@Composable
private fun topSection() {
    // الليلي والنهاري
    val uiColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = "Image shape",
            contentScale = ContentScale.FillBounds
        )
        Row(
            modifier = Modifier.padding(top = 80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(42.dp),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(id = R.string.the_totet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(alignment = Alignment.BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}