package com.andrews.ghanatunes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*

import androidx.compose.runtime.getValue
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andrews.ghanatunes.models.NewsModel
import com.andrews.ghanatunes.screens.NewsScreen
import com.andrews.ghanatunes.screens.ProfileScreen
import com.andrews.ghanatunes.screens.RadioScreen
import com.andrews.ghanatunes.ui.theme.GhanaTunesTheme
import com.andrews.ghanatunes.viewmodels.MainActivityViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //State hoisting?
    private val viewmodel by viewModels<MainActivityViewModel>()


    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            GhanaTunesTheme {
                val navController = rememberNavController()
                val navigationDestinations = listOf<NavigationDestination>(
                    NavigationDestination.News,
                    NavigationDestination.Radios,
                    NavigationDestination.Profile
                )
                Scaffold(

                    bottomBar = {
                       BottomNavigation(backgroundColor = Color.White){
                           val navBackStackEntry by navController.currentBackStackEntryAsState()
                           val currentDestination = navBackStackEntry?.destination
                           navigationDestinations.forEach { navigationDestination ->
                              BottomNavigationItem(
                                  selected = currentDestination?.hierarchy?.any {it.route == navigationDestination.route} == true,
                                  onClick = { 
                                            navController.navigate(navigationDestination.route){
                                                popUpTo(navController.graph.findStartDestination().id){
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                  },
                                  label = {Text(navigationDestination.title)},
                                  alwaysShowLabel = false,
                                  icon = {Icon(painterResource(id = navigationDestination.iconResourceId), contentDescription = "test")}
                              )
                           }
                       }
                    }
                ){ innerPadding ->
                   NavHost(navController = navController, startDestination = NavigationDestination.News.route ){
                       composable(NavigationDestination.News.route){ NewsScreen()}
                       composable(NavigationDestination.Radios.route){ RadioScreen()}
                       composable(NavigationDestination.Profile.route){ ProfileScreen()}
                   }
                }
            }
        }
    }
}
