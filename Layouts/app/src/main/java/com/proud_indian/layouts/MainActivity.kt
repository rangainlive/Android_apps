package com.proud_indian.layouts

import android.graphics.Paint.Align
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.benchmark.perfetto.Row
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.proud_indian.layouts.ui.theme.LayoutsTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android", modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    MyLayouts(name = name)
//    MyButtons()
//    MyCheckBox()
//    MyRadioButton()
//    MySwitch()
//    MyDropDown()
//    MyToastMessage()
//    MySnackbarMessage()
//    MyDialogeMessage()
    MyTopAppBarMessage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBarMessage() {
    val actionText = remember {
        mutableStateOf("Actions will be shown here")
    }
    val menuStatus = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {
                        actionText.value = "Navigation icon is clicked"
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation Icon")
                    }
                },
                title = {
                    Column {
                        Text(text = "Top App Bar", color = Color.White, fontSize = 20.sp)
                        Text(text = "Subtitle", color = Color.White, fontSize = 14.sp)
                    }
                },
                actions = {
                    IconButton(onClick = { actionText.value = "Share Icon is clicked" }) {
                        Icon(Icons.Filled.Share, contentDescription = "share-icon")
                    }
                    IconButton(onClick = { actionText.value = "Search Icon is clicked" }) {
                        Icon(Icons.Filled.Search, contentDescription = "search-icon")
                    }
                    IconButton(onClick = { menuStatus.value = true }) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "more-icon")

                        DropdownMenu(
                            expanded = menuStatus.value,
                            onDismissRequest = { menuStatus.value = false })
                        {
                            DropdownMenuItem(
                                text = { Text(text = "Settings") },
                                onClick = {
                                    menuStatus.value = false
                                    actionText.value = "Settings is clicked"
                                }
                            )

                            DropdownMenuItem(
                                text = { Text(text = "Logout") },
                                onClick = {
                                    menuStatus.value = false
                                    actionText.value = "Logout is clicked"
                                }
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    navigationIconContentColor = Color.Black,
                    actionIconContentColor = Color.White,
                    titleContentColor = Color.Blue
                )
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = actionText.value,
                    color = Color.Companion.Black,
                    fontSize = 18.sp
                )
            }
        }
    )
}

@Composable
fun MyDialogeMessage() {
    val dialogStatus = remember {
        mutableStateOf(false)
    }

    val textColor = remember {
        mutableStateOf(Color.White)
    }

    val myContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            dialogStatus.value = true
        }) {
            Text(text = "Show Dialog Message", color = textColor.value)
        }
        if (dialogStatus.value) {
            AlertDialog(
                onDismissRequest = {
                    dialogStatus.value = true
                },
                icon = {
                },
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.size(10.dp))
                        Text(
                            text = "Dialog Message",
                            color = Color.Red,
                            fontSize = 20.sp
                        )
                    }
                },
                text = {
                    Text(
                        text = "Do you want to change the text color of the button",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                },
                containerColor = Color.Gray,
                shape = RoundedCornerShape(10.dp),
                confirmButton = {
                    Button(
                        onClick = {
                            dialogStatus.value = false
                            textColor.value = Color.Red
                            Toast.makeText(
                                myContext,
                                "Confirm button is clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color.Green
                            ),
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(
                            text = "Yes",
                            color = Color.White,
                            fontSize = 18.sp
                        )
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            dialogStatus.value = false
                            Toast.makeText(
                                myContext,
                                "Dismiss button is clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = ButtonDefaults
                            .buttonColors(
                                containerColor = Color.Red
                            ),
                        modifier = Modifier.width(100.dp)
                    ) {
                        Text(
                            text = "No",
                            color = Color.Black,
                            fontSize = 18.sp
                        )
                    }
                })
        }
    }
}

@Composable
fun MySnackbarMessage() {

    val myContext = LocalContext.current
    val mySnackbarHostState = remember {
        SnackbarHostState()
    }

    val myCoroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = mySnackbarHostState
            ) {
                Snackbar(
                    snackbarData = it,
                    containerColor = Color.Red,
                    contentColor = Color.White,
                    actionColor = Color.Black,
                    dismissActionContentColor = Color.Blue
                )
            }
        },
        content = { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        myCoroutineScope.launch {
                            val result = mySnackbarHostState.showSnackbar(
                                message = "This is the Snackbar Message",
                                actionLabel = "Show Toast",
                                duration = SnackbarDuration.Long,
                                withDismissAction = true
                            )

                            if (result == SnackbarResult.ActionPerformed) {
                                Toast.makeText(
                                    myContext,
                                    "Short living Toast Message",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }) {
                    Text(text = "Show Snackbar Message")
                }
            }
        }
    )
}

@Composable
fun MyToastMessage() {
    val myContext = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            Toast.makeText(myContext, "This is a Toast Message", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Show Toast Message")
        }
    }
}

@Composable
fun MyDropDown() {
    val selectedCity = remember {
        mutableStateOf(
            "" +
                    "Chennai"
        )
    }
    val dropDownStatus = remember {
        mutableStateOf(false)
    }
    val cities = listOf("Chennai", "Delhi", "Mumbai", "Kolkata", "Bangalore")
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box() {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable {
                    dropDownStatus.value = true
                }
            ) {
                Text(
                    text = selectedCity.value,
                    modifier = Modifier.clickable {
                        dropDownStatus.value = true
                    })
                Image(
                    painter = painterResource(id = R.drawable.drop),
                    contentDescription = "dropdown",
                )
            }
            DropdownMenu(
                expanded = dropDownStatus.value,
                onDismissRequest = {
                    dropDownStatus.value = false
                }
            ) {
                cities.forEachIndexed { index, city ->
                    DropdownMenuItem(
                        text = { Text(text = city) },
                        onClick = {
                            dropDownStatus.value = false
                            selectedCity.value = city
                        })
                }
            }
        }
    }
}

@Composable
fun MySwitch() {
    val switchState = remember {
        mutableStateOf(false)
    }
    val myText = remember {
        mutableStateOf("The image is visible")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(50.dp))

        Switch(
            checked = switchState.value, onCheckedChange = {
                switchState.value = it
            }, colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Blue,
                checkedTrackColor = Color.Red,
            )
        )

        Spacer(modifier = Modifier.size(50.dp))

        Image(
            painter = painterResource(id = R.drawable.bank),
            contentDescription = "bank",
            modifier = Modifier
                .size(300.dp)
                .alpha(if (switchState.value) 1F else 0F),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )

        Text(
            text = if (switchState.value) "The image is visible" else "The image is invisible",
            color = Color.White,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Blue)
                .width(300.dp)
                .padding(top = 10.dp, bottom = 10.dp)
        )
    }
}

@Composable
fun MyRadioButton() {
    val myBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val radioIndex = remember {
        mutableStateOf(0)
    }

    val radioTexts = listOf("Red", "Green", "Yellow")
    val colorLists = listOf(Color.Red, Color.Green, Color.Yellow)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(myBackgroundColor.value),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column() {
            radioTexts.forEachIndexed { position, name ->
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
                    radioIndex.value = position
                    myBackgroundColor.value = colorLists.get(position)
                }) {
                    RadioButton(
                        selected = name == radioTexts[radioIndex.value], onClick = {
                            radioIndex.value = position
                            myBackgroundColor.value = colorLists.get(position)
                        }, colors = RadioButtonDefaults.colors(Color.Blue)
                    )

                    Text(text = name)
                }
            }
        }
    }
}

@Composable
fun MyLayouts(name: String) {
    Column {
        Box(
            modifier = Modifier
                .background(Color.Cyan)
                .height(200.dp)
                .width(300.dp)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.LightGray)
                )
                Column {
                    Text(
                        text = "Hello"
                    )
                    Text(
                        text = "$name!"
                    )
                }
            }
        }
    }
}


@Composable
fun MyButtons(modifier: Modifier = Modifier) {
    val myButtonColor = remember {
        mutableStateOf(Color.Red)
    }

    val myButtonText = remember {
        mutableStateOf("Click here")
    }

    val myButtonTextColor = remember {
        mutableStateOf(Color.Black)
    }
    val myText = remember {
        mutableStateOf("Hello, Mage!")
    }
    val myTextColor = remember {
        mutableStateOf(Color.Black)
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bank),
            contentDescription = "icon",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = myText.value,
            color = myTextColor.value,
            fontSize = 24.sp,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.size(30.dp))
        Button(
            onClick = {
                myButtonColor.value = Color.Green
                myButtonText.value = "Love"
                myButtonTextColor.value = Color.White
                myText.value = "Ranga Loves You!!!"
                myTextColor.value = Color.Red
            }, modifier = Modifier.size(250.dp, 60.dp), colors = ButtonDefaults.buttonColors(
                containerColor = myButtonColor.value
            ), shape = RoundedCornerShape(15), border = BorderStroke(3.dp, Color.Yellow)

        ) {
            Text(
                text = myButtonText.value,
                color = myButtonTextColor.value,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.size(30.dp))
        TextField(
            value = valueOnTextField.value,
            onValueChange = {
                valueOnTextField.value = it
            },
            label = { Text(text = " Enter your name", color = Color.Gray) },
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Color.Yellow,
                unfocusedLabelColor = Color.White,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle.Default.copy(fontSize = 20.sp),
            shape = RoundedCornerShape(40),
            maxLines = 4,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    val labelText = remember {
        mutableStateOf("What is your Gender")
    }
    val firstCheckBox = remember {
        mutableStateOf(false)
    }

    val secondCheckBox = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF027CDD)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = labelText.value,
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .width(300.dp)
                .background(Color(0xFFE91E63))
                .padding(top = 15.dp, bottom = 15.dp),
            textAlign = TextAlign.Center
        )
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = firstCheckBox.value, onCheckedChange = {
                    firstCheckBox.value = it
                })

                Text(text = "Male", fontSize = 20.sp, color = Color.White)
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = secondCheckBox.value, onCheckedChange = {
                    secondCheckBox.value = it
                })

                Text(text = "Female", fontSize = 20.sp, color = Color.White)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LayoutsTheme {
        Greeting("Android")
    }
}