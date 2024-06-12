package com.proud_indian.planit.pages.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CheckListPage(navController: NavController) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

    }
}

@Composable
fun ListPageView(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {

        }
    }
}


@Preview
@Composable
fun ListPagePreview(modifier: Modifier = Modifier) {
    ListPageView()
}