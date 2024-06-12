package com.proud_indian.navigation

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyLazyListingPage(navController: NavController) {
    val countryList = retrieveCountries()

    val myContext = LocalContext.current

    val topBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "ListExample", fontSize = 20.sp)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White,
                    scrolledContainerColor = Color.Magenta
                ),
                scrollBehavior = topBarBehavior
            )
        },
        content = {
            //LazyVerticalGrid
            //LazyHorizontalGrid
            LazyVerticalGrid(
                modifier = Modifier.padding(it),
                columns = GridCells.Adaptive(100.dp) // Property for -> VerticalGrid
//                rows = GridCells.Adaptive(200.dp) // Property for -> HorizontalGrid
            ) {
                items(
                    count = countryList.count(),
                    itemContent = { index ->
                        val country = countryList[index]
                        //Card
                        Card(
                            onClick = {
                                Toast.makeText(
                                    myContext,
                                    "You are clicked ${country.countryName}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier
                                .size(180.dp, 100.dp)
                                .height(120.dp)
                                .padding(7.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.Green,
                            ),
                            border = BorderStroke(1.dp, Color.Black),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(7.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Image(
                                        country.countryImg,
                                        contentDescription = country.countryName,
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(RoundedCornerShape(100)),
                                        contentScale = ContentScale.Crop,
                                        alignment = Alignment.Center
                                    )
//                                    Column(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp),
//                                    ) {
//                                        Text(
//                                            text = "Title: ${country.countryName}",
//                                            fontSize = 20.sp,
//                                            color = Color.Black
//                                        )
//                                        Spacer(modifier = Modifier.height(3.dp))
//                                        Text(
//                                            text = country.countryDetails,
//                                            fontSize = 16.sp,
//                                            color = Color.Black
//                                        )
//                                    }
                                    Button(
                                        onClick = {
                                            navController.navigate("listDetails/${country.countryId}")
                                        },
                                        modifier = Modifier.width(60.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            containerColor = Color.White
                                        ),
                                        border = BorderStroke(1.dp, Color.Black)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.ArrowForward,
                                            contentDescription = "details",
                                            tint = Color.Red
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }
        }
    )
}

//LazyRow Example
//fun MyLazyListingPage(navController: NavController) {
//    val countryList = retrieveCountries()
//
//    val myContext = LocalContext.current
//
//    val topBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//
//    Scaffold(
//        modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "ListExample", fontSize = 20.sp)
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Red,
//                    titleContentColor = Color.White,
//                    scrolledContainerColor = Color.Magenta
//                ),
//                scrollBehavior = topBarBehavior
//            )
//        },
//        content = {
//            //LazyRow
//            LazyRow(
//                modifier = Modifier.padding(it)
//            ) {
//                items(
//                    count = countryList.count(),
//                    itemContent = { index ->
//                        val country = countryList[index]
//                        //Card
//                        Card(
//                            onClick = {
//                                Toast.makeText(
//                                    myContext,
//                                    "You are clicked ${country.countryName}",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            },
//                            modifier = Modifier
//                                .size(180.dp, 100.dp)
//                                .height(120.dp)
//                                .padding(7.dp),
//                            colors = CardDefaults.cardColors(
//                                containerColor = Color.Green,
//                            ),
//                            border = BorderStroke(1.dp, Color.Black),
//                        ) {
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .padding(7.dp),
//                                verticalAlignment = Alignment.CenterVertically,
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(10.dp),
//                                    verticalAlignment = Alignment.CenterVertically,
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Image(
//                                        country.countryImg,
//                                        contentDescription = country.countryName,
//                                        modifier = Modifier
//                                            .size(80.dp)
//                                            .clip(RoundedCornerShape(100)),
//                                        contentScale = ContentScale.Crop,
//                                        alignment = Alignment.Center
//                                    )
////                                    Column(
////                                        modifier = Modifier
////                                            .padding(start = 20.dp),
////                                    ) {
////                                        Text(
////                                            text = "Title: ${country.countryName}",
////                                            fontSize = 20.sp,
////                                            color = Color.Black
////                                        )
////                                        Spacer(modifier = Modifier.height(3.dp))
////                                        Text(
////                                            text = country.countryDetails,
////                                            fontSize = 16.sp,
////                                            color = Color.Black
////                                        )
////                                    }
//                                    Button(
//                                        onClick = {
//                                            navController.navigate("listDetails/${country.countryId}")
//                                        },
//                                        modifier = Modifier.width(60.dp),
//                                        colors = ButtonDefaults.buttonColors(
//                                            containerColor = Color.White
//                                        ),
//                                        border = BorderStroke(1.dp, Color.Black)
//                                    ) {
//                                        Icon(
//                                            imageVector = Icons.Filled.ArrowForward,
//                                            contentDescription = "details",
//                                            tint = Color.Red
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
//                )
//            }
//        }
//    )
//}

// LazyColumn Example

//fun MyLazyListingPage(navController: NavController) {
//    val countryList = retrieveCountries()
//
//    val myContext = LocalContext.current
//
//    val topBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()
//
//    Scaffold(
//        modifier = Modifier.nestedScroll(topBarBehavior.nestedScrollConnection),
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "ListExample", fontSize = 20.sp)
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Red,
//                    titleContentColor = Color.White,
//                    scrolledContainerColor = Color.Magenta
//                ),
//                scrollBehavior = topBarBehavior
//            )
//        },
//        content = {
//            //LazyColumn
//            LazyColumn(
//                modifier = Modifier.padding(it)
//            ) {
//                items(
//                    count = countryList.count(),
//                    itemContent = { index ->
//                        val country = countryList[index]
//                        //Card
//                        Card(
//                            onClick = {
//                                Toast.makeText(
//                                    myContext,
//                                    "You are clicked ${country.countryName}",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            },
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .height(120.dp)
//                                .padding(7.dp),
//                            colors = CardDefaults.cardColors(
//                                containerColor = Color.Green,
//                            ),
//                            border = BorderStroke(1.dp, Color.Black),
//                        ) {
//                            Row(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .padding(7.dp),
//                                verticalAlignment = Alignment.CenterVertically,
//                                horizontalArrangement = Arrangement.SpaceBetween
//                            ) {
//                                Row(
//                                    modifier = Modifier
//                                        .fillMaxWidth()
//                                        .padding(10.dp),
//                                    verticalAlignment = Alignment.CenterVertically,
//                                    horizontalArrangement = Arrangement.SpaceBetween
//                                ) {
//                                    Image(
//                                        country.countryImg,
//                                        contentDescription = country.countryName,
//                                        modifier = Modifier
//                                            .size(80.dp)
//                                            .clip(RoundedCornerShape(100)),
//                                        contentScale = ContentScale.Crop,
//                                        alignment = Alignment.Center
//                                    )
//                                    Column(
//                                        modifier = Modifier
//                                            .padding(start = 20.dp),
//                                    ) {
//                                        Text(
//                                            text = "Title: ${country.countryName}",
//                                            fontSize = 20.sp,
//                                            color = Color.Black
//                                        )
//                                        Spacer(modifier = Modifier.height(3.dp))
//                                        Text(
//                                            text = country.countryDetails,
//                                            fontSize = 16.sp,
//                                            color = Color.Black
//                                        )
//                                    }
//                                    Button(
//                                        onClick = {
//                                            navController.navigate("listDetails/${country.countryId}")
//                                        },
//                                        modifier = Modifier.width(60.dp),
//                                        colors = ButtonDefaults.buttonColors(
//                                            containerColor = Color.White
//                                        ),
//                                        border = BorderStroke(1.dp, Color.Black)
//                                    ) {
//                                        Icon(
//                                            imageVector = Icons.Filled.ArrowForward,
//                                            contentDescription = "details",
//                                            tint = Color.Red
//                                        )
//                                    }
//                                }
//                            }
//                        }
//                    }
//                )
//            }
//        }
//    )
//}