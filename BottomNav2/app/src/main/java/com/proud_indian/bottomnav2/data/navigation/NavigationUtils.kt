package com.proud_indian.bottomnav2.data.navigation

import androidx.navigation.NavDestination
import com.proud_indian.bottomnav2.domain.navigation.NavRoute

object NavigationUtils {

    val SCREEN_LIST = listOf(
        NavRoute.Project,
        NavRoute.Events,
        NavRoute.Home,
        NavRoute.List,
        NavRoute.Profile
    )

    fun isCheckedNavRoute(
        navDestination: NavDestination?,
        navRoute: NavRoute
    ) : Boolean {

        return navDestination?.route.toString() == navRoute.route
    }
}