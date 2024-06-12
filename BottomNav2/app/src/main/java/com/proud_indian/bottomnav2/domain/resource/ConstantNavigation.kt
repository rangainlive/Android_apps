package com.proud_indian.bottomnav2.domain.resource

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.Color

object ConstantNavigation {

    const val HOME_ROUTE = "HOME"
    const val PROFILE_ROUTE = "PROFILE"
    const val PROJECT_ROUTE = "PROJECT"
    const val LIST_ROUTE = "LIST"
    const val EVENTS_ROUTE = "EVENTS"

    const val HOME_NAME = "Home"
    const val PROFILE_NAME = "Profile"
    const val PROJECT_NAME = "Projects"
    const val LIST_NAME = "List"
    const val EVENTS_NAME = "Events"

    val HOME_SELECTED_ICON = Icons.Filled.Home
    val PROFILE_SELECTED_ICON = Icons.Filled.Person
    val PROJECT_SELECTED_ICON = Icons.Filled.CheckCircle
    val LIST_SELECTED_ICON = Icons.Filled.List
    val EVENTS_SELECTED_ICON = Icons.Filled.DateRange

    val HOME_UNSELECTED_ICON = Icons.Outlined.Home
    val PROFILE_UNSELECTED_ICON = Icons.Outlined.Person
    val PROJECT_UNSELECTED_ICON = Icons.Outlined.CheckCircle
    val LIST_UNSELECTED_ICON = Icons.Outlined.List
    val EVENTS_UNSELECTED_ICON = Icons.Outlined.DateRange

    val HOME_CONTAINER_COLOR = Color(red = 76, green = 175, blue = 80, alpha = 255)
    val PROFILE_CONTAINER_COLOR = Color(red = 76, green = 175, blue = 80, alpha = 255)
    val PROJECT_CONTAINER_COLOR = Color(red = 76, green = 175, blue = 80, alpha = 255)
    val LIST_CONTAINER_COLOR = Color(red = 76, green = 175, blue = 80, alpha = 255)
    val EVENTS_CONTAINER_COLOR = Color(red = 76, green = 175, blue = 80, alpha = 255)

    val HOME_CONTENT_COLOR = Color.White
    val PROFILE_CONTENT_COLOR = Color.White
    val PROJECT_CONTENT_COLOR = Color.White
    val LIST_CONTENT_COLOR = Color.White
    val EVENTS_CONTENT_COLOR = Color.White
}