package com.proud_indian.planit.pages.intro

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun LandingPage(navController: NavController) {
    val myContext = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
//            moveOnToHomePage(myContext, navController)
            navController.navigate("home")
        }) {
            Text(text = "Get Started")
        }
    }
}

fun moveOnToHomePage(myContext: Context, navController: NavController) {

}