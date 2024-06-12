package com.proud_indian.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList

@Composable
fun retrieveCountries() : SnapshotStateList<CountryModel>{
    val countryList = remember {
        mutableStateListOf(
            CountryModel(1, "Arul", "This is Add", Icons.Filled.Add),
            CountryModel(2, "Balu", "This is Call", Icons.Filled.Call),
            CountryModel(3, "Cinrasu", "This is Edit", Icons.Filled.Edit),
            CountryModel(4, "Deepan", "This is AccountBox", Icons.Filled.AccountBox),
            CountryModel(5, "Ezhumalai", "This is Add", Icons.Filled.AccountCircle),
            CountryModel(6, "Fathima", "This is Call", Icons.Filled.AddCircle),
            CountryModel(7, "Ganesh", "This is Edit", Icons.Filled.Build),
            CountryModel(8, "Hariharan", "This is AccountBox", Icons.Filled.CheckCircle),
        )
    }
    return countryList;
}