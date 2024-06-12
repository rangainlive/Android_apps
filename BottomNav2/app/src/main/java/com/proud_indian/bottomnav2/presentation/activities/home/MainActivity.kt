package com.proud_indian.bottomnav2.presentation.activities.home

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.proud_indian.bottomnav2.R
import com.proud_indian.bottomnav2.presentation.navigation.BottomNavigation
import com.proud_indian.bottomnav2.presentation.theme.BottomNav2Theme
import com.proud_indian.bottomnav2.storage.viewmodel.CheckListViewModel

class MainActivity : ComponentActivity() {

        private val mainViewModel by viewModels<MainViewModel>()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val todoViewModel = ViewModelProvider(this)[CheckListViewModel::class.java]
            installSplashScreen()
            setContent {
                BottomNav2Theme {
                    val navHostController = rememberNavController()
                    Box(modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        BottomNavigation(
                            mainViewModel = mainViewModel,
                            navHostController = navHostController
                        )
                    }
                }
            }
        }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LearnAppBar() {
//    val context = LocalContext.current.applicationContext
//    TopAppBar(
//        title = { Text(text = "Whatsapp")},
//        navigationIcon = {
//            IconButton(onClick = {
//                Toast.makeText(context, "Whatsapp", Toast.LENGTH_SHORT).show()
//            }) {
//                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "app bar icon")
//
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors()
//        )
//}
//
//@Preview
//@Composable
//fun TopAppBarPreview() {
//    BottomNav2Theme {
//        LearnAppBar()
//    }
//}