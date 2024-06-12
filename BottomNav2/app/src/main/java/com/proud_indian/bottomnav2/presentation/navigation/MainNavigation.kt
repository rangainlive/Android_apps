package com.proud_indian.bottomnav2.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.proud_indian.bottomnav2.domain.navigation.NavRoute
import com.proud_indian.bottomnav2.presentation.activities.home.MainViewModel
import com.proud_indian.bottomnav2.presentation.screen.EventsScreen
import com.proud_indian.bottomnav2.presentation.screen.HomeScreen
import com.proud_indian.bottomnav2.presentation.screen.ListScreen
import com.proud_indian.bottomnav2.presentation.screen.ProfileScreen
import com.proud_indian.bottomnav2.presentation.screen.ProjectScreen

@Composable
fun MainNavigation(
    modifier: Modifier,
    mainViewModel: MainViewModel,
    navHostController: NavHostController
) {

    NavHost(
        navController = navHostController,
        startDestination = NavRoute.Home.route
    ) {
        composable(
            route = NavRoute.Project.route
        ) { navBackStackEntry: NavBackStackEntry ->

            ProjectScreen()
        }
        composable(
            route = NavRoute.Events.route
        ) { navBackStackEntry: NavBackStackEntry ->

            EventsScreen()
        }
        composable(
            route = NavRoute.Home.route
        ) { navBackStackEntry: NavBackStackEntry ->

            HomeScreen(mainViewModel = mainViewModel)
        }
        composable(
            route = NavRoute.List.route
        ) { navBackStackEntry: NavBackStackEntry ->

            ListScreen()
        }
        composable(
            route = NavRoute.Profile.route
        ) { navBackStackEntry: NavBackStackEntry ->

            ProfileScreen()
        }
    }
}
