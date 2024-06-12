package com.example.stateexample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


@Composable
fun StateTestScreen() {
    var name by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        MyText(name)
        MyTextField(name, onNameChange = {
            name = it
        })
    }
    
}

@Composable
fun MyText(name: String) {
    Text(text = "Hello $name" , style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name: String, onNameChange: (String)-> Unit) {
    OutlinedTextField(value =name,
        onValueChange = {onNameChange(it) },
        label = {Text(text = "Enter the Name")})
}