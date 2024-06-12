package com.proud_indian.navigation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {

    val username = remember {
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf("")
    }
    val myContext = LocalContext.current

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = "Main Page", color = Color.White, fontSize = 20.sp)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Green
            ),
        )
    }, content = { paddingValue ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = username.value,
                onValueChange = {
                    username.value = it
                },
                label = { Text(text = "Enter your name") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color.LightGray,
                    unfocusedLabelColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Blue,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .size(300.dp, 60.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(10)),
                textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                shape = RoundedCornerShape(20),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.size(15.dp))
            TextField(value = age.value,
                onValueChange = {
                    age.value = it
                },
                label = { Text(text = "Enter your Age") },
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Blue,
                    focusedLabelColor = Color.LightGray,
                    unfocusedLabelColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White
                ),
                modifier = Modifier
                    .size(300.dp, 60.dp)
                    .border(1.dp, Color.Black, RoundedCornerShape(10)),
                textStyle = TextStyle(fontSize = 18.sp, color = Color.Black),
                shape = RoundedCornerShape(20),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Button(
                onClick = {
                    if(username.value.isEmpty() || age.value.isEmpty()){
                        Toast.makeText(myContext, "Enter the valid data to submit data", Toast.LENGTH_SHORT).show()
                    }else {
                        try {
                            navController.navigate("second/${username.value}/${age.value}"){
//                              popUpTo("main"){inclusive = true} --> Removes all pages up to MainPage including MainPage.
                            }
                        }catch (e : IllegalArgumentException){
                            Toast.makeText(myContext, "Enter valid Data: $e", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                modifier = Modifier.size(200.dp, 60.dp),
                shape = RoundedCornerShape(40),
                border = BorderStroke(width = 1.dp, color = Color.Gray)
                ) {
                Text(
                    text = "Submit",
                    color = Color.Black,
                    fontSize = 24.sp)

            }
        }
    })
}