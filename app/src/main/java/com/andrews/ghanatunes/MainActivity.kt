package com.andrews.ghanatunes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andrews.ghanatunes.models.NewsModel
import com.andrews.ghanatunes.ui.theme.GhanaTunesTheme
import com.andrews.ghanatunes.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //State hoisting?
    private val viewmodel by viewModels<MainActivityViewModel>()


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
                    topBar = {
                        SmallTopAppBar(
                            title = {Text("Ghana tunes ")},
                            navigationIcon = {
                                IconButton(
                                    onClick = { TODO()}
                                ){
                                    Icon(Icons.Filled.Menu, contentDescription = "TestDescription")
                                }
                            }
                        )
                    },
                    content = {
                        Greeting("test")
                    },
                    bottomBar = {
                       BottomNavigation{
                           val navBackStackEntry by navController.currentBackStackEntryAsState()
                           val currentDestination = navBackStackEntry?.destination
                           navigationDestinations.forEach { navigationDestination ->
                              BottomNavigationItem(
                                  selected = currentDestination?.hierarchy?.any {it.route == navigationDestination.route} == true,
                                  onClick = { /*TODO*/ },
                                  label = {Text(navigationDestination.title)},
                                  icon = {Icon(painterResource(id = navigationDestination.iconResourceId), contentDescription = "test")}
                              )
                           }
                       }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun PrintNewsModel(newsModel: NewsModel){
    Text("Title: ${newsModel.title}")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GhanaTunesTheme {
        Greeting("Android")
    }
}