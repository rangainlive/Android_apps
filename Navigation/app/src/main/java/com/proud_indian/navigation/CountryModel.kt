package com.proud_indian.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class CountryModel(
    val countryId : Int,
    val countryName: String,
    val countryDetails: String,
    val countryImg: ImageVector,
)
