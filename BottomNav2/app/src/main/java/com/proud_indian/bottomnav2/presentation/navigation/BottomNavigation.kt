package com.proud_indian.bottomnav2.presentation.navigation

import android.widget.ImageButton
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.proud_indian.bottomnav2.data.navigation.NavigationUtils
import com.proud_indian.bottomnav2.domain.navigation.NavRoute
import com.proud_indian.bottomnav2.presentation.activities.home.MainViewModel
import com.proud_indian.bottomnav2.presentation.theme.GreenJC
import com.proud_indian.bottomnav2.presentation.theme.LightWhite
import com.proud_indian.bottomnav2.presentation.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(
    mainViewModel: MainViewModel,
    navHostController: NavHostController
) {
    val context = LocalContext.current

    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val screenList by mainViewModel.screenList.collectAsStateWithLifecycle()

    val navDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
//        topBar = {
//            // App bar with dynamic title based on selected bottom navigation item
//            val selectedNavItem = screenList.firstOrNull { navItem ->
//                NavigationUtils.isCheckedNavRoute(
//                    navDestination = navDestination,
//                    navRoute = navItem
//                )
//            }
//            selectedNavItem?.let { navItem ->
//                TopAppBar(
//                    title = { Text(text = navItem.name)},
//                    navigationIcon = {
//                        IconButton(onClick = { /*TODO*/ }) {
//                            Icon(imageVector = navItem.selectedIcon, contentDescription = navItem.name)
//                        }
//                    },
//                    colors = TopAppBarDefaults.topAppBarColors(
//                        containerColor = GreenJC,
//                        titleContentColor = Color.White,
//                        navigationIconContentColor = Color.White
//                    )
//                )
//            }
//        },
        bottomBar = {

            EmptyBottomBar(
                containerColor = GreenJC,
                contentColor = MaterialTheme.colorScheme.onSurface,
                tonalElevation = 4.dp
            ) {

                screenList.forEach { navItem: NavRoute ->

                    val isSelected = NavigationUtils.isCheckedNavRoute(
                        navDestination = navDestination,
                        navRoute = navItem
                    )

                    BottomNavItem(
                        isSelected = isSelected,
                        label = navItem.name,
                        icon = when (isSelected) {

                            true -> {

                                navItem.selectedIcon
                            }

                            false -> {

                                navItem.unSelectedIcon
                            }
                        },
                        shape = MaterialTheme.shapes.extraLarge,
                        containerColor = LightWhite,
                        contentColor = Color.Black,
                        enabled = true,
                        onItemClick = {

                            navHostController.navigate(
                                route = navItem.route
                            ) {

                                popUpTo(
                                    route = navHostController.graph.startDestinationRoute.toString()
                                ) {

                                    saveState = true
                                }

                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues: PaddingValues ->

        MainNavigation(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
            mainViewModel = mainViewModel,
            navHostController = navHostController
        )
    }
}