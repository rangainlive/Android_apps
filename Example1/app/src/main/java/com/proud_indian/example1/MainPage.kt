package com.proud_indian.example1

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage() {

    val myContext = LocalContext.current

    val todoName = remember {
        mutableStateOf("")
    }

    val todoList = readData(myContext)

    val focusManager = LocalFocusManager.current

    val deleteDialogWindow = remember {
        mutableStateOf(false)
    }

    val clickedIndexValue = remember {
        mutableStateOf(0)
    }

    val editDialogStatus = remember {
        mutableStateOf(false)
    }

    val editItem = remember {
        mutableStateOf("")
    }

    val textDialogStatus = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(top = 50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = todoName.value,
                onValueChange = {
                    todoName.value = it
                },
                label = { Text(text = "Enter Todo") },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.LightGray,
                    unfocusedLabelColor = Color.Gray,
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Blue,
                    cursorColor = Color.White
                ),
                shape = RoundedCornerShape(5),
                modifier = Modifier
                    .border(1.dp, Color.Black, RoundedCornerShape(5.dp))
                    .weight(7f)
                    .height(60.dp),
                textStyle = TextStyle(textAlign = TextAlign.Left)
            )

            Spacer(modifier = Modifier.size(3.dp))

            Button(
                onClick = {
                    if (todoName.value.isNotEmpty()) {
                        todoList.add(todoName.value)
                        writeData(todoList, myContext)
                        todoName.value = ""
                        focusManager.clearFocus()
                    } else {
                        Toast.makeText(myContext, "Please enter a TODO", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .weight(3F)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(5.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(text = "Add", fontSize = 20.sp)
            }
        }

        LazyColumn {
            items(
                count = todoList.size,
                itemContent = { index ->
                    val item = todoList[index]
                    Card(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Cyan,
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = item,
                                color = Color.Black,
                                fontSize = 18.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .width(300.dp)
                                    .clickable {
                                        editItem.value = item
                                        textDialogStatus.value = true
                                    }
                            )

                            Row() {
                                IconButton(
                                    onClick = {
                                        clickedIndexValue.value = index
                                        editDialogStatus.value = true
                                        editItem.value = item
                                    }) {
                                    Icon(
                                        Icons.Filled.Edit,
                                        contentDescription = "edit",
                                        tint = Color.White
                                    )
                                }

                                IconButton(
                                    onClick = {
                                        deleteDialogWindow.value = true
                                        clickedIndexValue.value = index
                                    }) {
                                    Icon(
                                        Icons.Filled.Delete,
                                        contentDescription = "delete",
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }

        if(deleteDialogWindow.value){
            AlertDialog(
                onDismissRequest = { deleteDialogWindow.value = false },
                title = {
                        Text(text = "Delete")
                },
                text = {
                       Text(text = "Do you want to delete this item ${todoList[clickedIndexValue.value]} from the List")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            todoList.removeAt(clickedIndexValue.value)
                            writeData(todoList, myContext)
                            deleteDialogWindow.value = false
                            Toast.makeText(myContext, "Selected item removed Successfully...", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = "Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            deleteDialogWindow.value = false
                        }
                    ) {
                        Text(text = "No")
                    }
                }
            )
        }

        if(editDialogStatus.value){
            AlertDialog(
                onDismissRequest = { deleteDialogWindow.value = false },
                title = {
                    Text(text = "Update Item ${editItem.value}")
                },
                text = {
                       TextField(
                           value = editItem.value,
                           onValueChange = {editItem.value = it}
                       )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            todoList[clickedIndexValue.value] = editItem.value
                            writeData(todoList, myContext)
                            editDialogStatus.value = false
                            Toast.makeText(myContext, "Item updated Successfully...", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = "Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            editDialogStatus.value = false
                        }
                    ) {
                        Text(text = "No")
                    }
                }
            )
        }

        if(textDialogStatus.value){
            AlertDialog(
                onDismissRequest = { textDialogStatus.value = false },
                title = {
                    Text(text = "Todo Item")
                },
                text = {
                    Text(text = editItem.value)
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            textDialogStatus.value = false
                        }
                    ) {
                        Text(text = "Close")
                    }
                }
            )
        }
    }
}