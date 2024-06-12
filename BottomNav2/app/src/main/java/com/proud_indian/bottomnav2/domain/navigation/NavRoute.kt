package com.proud_indian.bottomnav2.domain.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.proud_indian.bottomnav2.domain.resource.ConstantNavigation

sealed class NavRoute(
    val route: String,
    val name: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val containerColor: Color,
    val contentColor: Color
) {

    data object Home : NavRoute(
        route = ConstantNavigation.HOME_ROUTE,
        name = ConstantNavigation.HOME_NAME,
        selectedIcon = ConstantNavigation.HOME_SELECTED_ICON,
        unSelectedIcon = ConstantNavigation.HOME_UNSELECTED_ICON,
        containerColor = ConstantNavigation.HOME_CONTAINER_COLOR,
        contentColor = ConstantNavigation.HOME_CONTENT_COLOR
    )

    data object Profile : NavRoute(
        route = ConstantNavigation.PROFILE_ROUTE,
        name = ConstantNavigation.PROFILE_NAME,
        selectedIcon = ConstantNavigation.PROFILE_SELECTED_ICON,
        unSelectedIcon = ConstantNavigation.PROFILE_UNSELECTED_ICON,
        containerColor = ConstantNavigation.PROFILE_CONTAINER_COLOR,
        contentColor = ConstantNavigation.PROFILE_CONTENT_COLOR
    )

    data object Project : NavRoute(
        route = ConstantNavigation.PROJECT_ROUTE,
        name = ConstantNavigation.PROJECT_NAME,
        selectedIcon = ConstantNavigation.PROJECT_SELECTED_ICON,
        unSelectedIcon = ConstantNavigation.PROJECT_UNSELECTED_ICON,
        containerColor = ConstantNavigation.PROJECT_CONTAINER_COLOR,
        contentColor = ConstantNavigation.PROJECT_CONTENT_COLOR
    )

    data object List : NavRoute(
        route = ConstantNavigation.LIST_ROUTE,
        name = ConstantNavigation.LIST_NAME,
        selectedIcon = ConstantNavigation.LIST_SELECTED_ICON,
        unSelectedIcon = ConstantNavigation.LIST_UNSELECTED_ICON,
        containerColor = ConstantNavigation.LIST_CONTAINER_COLOR,
        contentColor = ConstantNavigation.LIST_CONTENT_COLOR
    )

    data object Events : NavRoute(
        route = ConstantNavigation.EVENTS_ROUTE,
        name = ConstantNavigation.EVENTS_NAME,
        selectedIcon = ConstantNavigation.EVENTS_SELECTED_ICON,
        unSelectedIcon = ConstantNavigation.EVENTS_UNSELECTED_ICON,
        containerColor = ConstantNavigation.EVENTS_CONTAINER_COLOR,
        contentColor = ConstantNavigation.EVENTS_CONTENT_COLOR
    )


}