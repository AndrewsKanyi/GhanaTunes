package com.andrews.ghanatunes.presentation.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.Pager
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.*
import com.andrews.ghanatunes.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@Preview(showBackground = true)
//@ExperimentalPagerApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SplashScreen(){

    HorizontalPager(count = 5){ page ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.primary)
        ){
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.d))
            val progress by animateLottieCompositionAsState(composition = composition)
            LottieAnimation(
                composition=composition,
                iterations = LottieConstants.IterateForever,
                speed = 0.4f,
                renderMode = RenderMode.HARDWARE,
            )
            Button(
                onClick = { /* ... */ },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Like")
            }
        }
    }
}



//@Preview(showBackground = true)
//@OptIn(ExperimentalPagerApi::class)
//@Composable
//fun HorizontalPagerTest(){
//    HorizontalPager(count = 10) {
//        Box(modifier = Modifier.fillMaxSize()){
//            Text(" hello world")
//        }
//
//    }
//}