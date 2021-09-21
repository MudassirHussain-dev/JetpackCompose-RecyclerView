package com.example.jetpackcomposestarting.uii

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposestarting.ui.theme.JetPackComposeStartingTheme
import com.example.jetpackcomposestarting.ui.theme.Purple700
import kotlinx.coroutines.delay


class SplashScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeStartingTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "splash_screen") {
                        composable("splash_screen") {
                            SplashScreen(navController)
                        }
                        composable("main_screen") {
                            MainScreen()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun SplashScreen(naveController: NavController) {
        val scale = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.6f,
                animationSpec = tween(
                    delayMillis = 800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    }
                )
            )
            delay(1000L)
            naveController.navigate("main_screen") {
                popUpTo("splash_screen") {
                    inclusive = true
                }
            }
        }
        Box(
            modifier = Modifier
                .background(Purple700)
                .fillMaxSize()
        ) {
            Text(
                text = "Splash Screen",
                color = Color.White,
                modifier = Modifier.scale(scale.value)
            )
        }
    }

    @Composable
    fun MainScreen() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue)
        ) {
            Text(
                text = "Main Screen",
                style = TextStyle(Color.White, fontSize = 20.sp),
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}