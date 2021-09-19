package com.example.jetpackcomposestarting

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposestarting.ui.theme.JetPackComposeStartingTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeStartingTheme {
                Surface() {
                    LoginScreen()
                }
            }
        }
    }

    private fun loginUserNamePassword(userName: String, password: String) {
        if (userName == "HMH" && password == "1") {
            startActivity(Intent(this@LoginActivity,RecyclerviewActivity::class.java))
            Toast.makeText(this@LoginActivity, "Success $userName  $password", Toast.LENGTH_SHORT).show()
        } else {
            startActivity(Intent(this@LoginActivity,RecyclerviewActivity::class.java))
            Toast.makeText(this@LoginActivity, "Failed  $userName  $password", Toast.LENGTH_SHORT).show()
        }
    }


    @Composable
    fun LoginScreen() {
        val userName = remember {
            mutableStateOf("")
        }
        val password = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,

            ) {

            Text(
                text = "Hello",
                fontSize = 20.sp,
                color = Color.Blue,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Welcome",
                fontSize = 20.sp,
                color = Color.Blue,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Back",
                fontSize = 20.sp,
                color = Color.Blue,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = userName.value,
                onValueChange = {
                    userName.value = it
                },
                leadingIcon = {
                    Icon(Icons.Filled.Person, contentDescription = "person")
                },
                label = {
                    Text(text = "User Name")
                },
                placeholder = {
                    Text(text = "Enter UserName")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Yellow
                )
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password.value,
                onValueChange = {
                    password.value = it
                },
                leadingIcon = {
                    Icon(Icons.Filled.Info, contentDescription = "person")
                },
                label = {
                    Text(text = "Password")
                },
                placeholder = {
                    Text(text = "Enter Password")
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Green,
                    unfocusedBorderColor = Yellow
                )
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { loginUserNamePassword(userName.toString(), password.toString()) }) {
                Text(text = "Login")
            }
            /*      OutlinedTextField(
                  value = userName.value,
                  onValueChange = {
                      userName.value = it
                  },
                  label = {
                      Text("Input")
                  },
                  colors = TextFieldDefaults.outlinedTextFieldColors(
                      focusedBorderColor = Green,
                      unfocusedBorderColor = Yellow
                  )
              )*/

        }
    }
}

