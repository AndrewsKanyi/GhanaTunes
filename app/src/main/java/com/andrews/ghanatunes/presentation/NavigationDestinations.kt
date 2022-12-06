package com.andrews.ghanatunes.presentation

import com.andrews.ghanatunes.R

sealed class NavigationDestination(val route:String,val title: String, val iconResourceId: Int){
    object Radios : NavigationDestination("radios", "Radio", R.drawable.ic_baseline_radio_24)
    object News : NavigationDestination("news","News",
        R.drawable.ic_newspaper_variant_multiple_outline
    )
    object Profile: NavigationDestination("profile", "Profile", R.drawable.ic_baseline_people_24)

    object FirstSplashScreen : NavigationDestination("firstSplashScreen", "fisrtSplashScreen", 0)
}
