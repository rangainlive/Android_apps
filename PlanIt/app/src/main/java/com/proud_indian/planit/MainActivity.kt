package com.proud_indian.planit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.proud_indian.planit.pages.home.HomePage
import com.proud_indian.planit.pages.intro.LandingPage
import com.proud_indian.planit.ui.theme.PlanItTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PlanItTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    RouteNavigation()
                }
            }
        }
    }
}


@Composable
fun RouteNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "intro"
    ) {
        composable("intro"){
            LandingPage(navController = navController)
        }

        // HomePage
        composable("home"){
            HomePage(navController = navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlanItTheme {
        RouteNavigation()
    }
}