package com.proud_indian.bottomnav2.presentation.activities.home

import androidx.lifecycle.ViewModel
import com.proud_indian.bottomnav2.data.navigation.NavigationUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {

    private val _screenList = MutableStateFlow(
        value = NavigationUtils.SCREEN_LIST
    )

    val screenList = _screenList.asStateFlow()


}