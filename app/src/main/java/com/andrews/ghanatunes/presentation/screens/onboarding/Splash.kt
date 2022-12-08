package com.andrews.ghanatunes.presentation.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.Pager
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue // only if using var
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.andrews.ghanatunes.R
import com.andrews.ghanatunes.presentation.NavigationDestination
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


//@ExperimentalPagerApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SplashScreen(navController: NavController){
    val pagerState = rememberPagerState()
    Column(modifier = Modifier
        .fillMaxSize(10f)
        .background(MaterialTheme.colorScheme.primary)) {
        HorizontalPager(count = 3, state = pagerState, modifier = Modifier
            .fillMaxSize()
            .weight(10f)){ page ->
            when (page){
                0 -> FirstPage()
                1 -> SecondPage()
                2-> Thirdpage(navController)

            }
        }
        HorizontalPagerIndicator(pagerState = pagerState, indicatorHeight = 5.dp, indicatorWidth = 25.dp,
            modifier = Modifier
                .weight(1f)
                .padding(5.dp)
                .align(Alignment.CenterHorizontally)
                .align(Alignment.Start))

    }

}

@Composable fun FirstPage(){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.d))
    val progress by animateLottieCompositionAsState(composition = composition)
    Column(
        modifier = Modifier


    ){
        LottieAnimation(
            modifier= Modifier
                .size(400.dp)
                .weight(7f),
            composition=composition,
            iterations = LottieConstants.IterateForever,
            speed = 0.4f,
            renderMode = RenderMode.HARDWARE,
        )
        Column(
            modifier= Modifier
                .weight(4.5f)
                .fillMaxSize(2f)
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
           Text(
               modifier = Modifier.fillMaxWidth(),
               color = Color.White,
               fontWeight = FontWeight.Bold,
               style = MaterialTheme.typography.headlineLarge ,
               text="Listen to the latest news around your favourite continent"
           )
        }
    }
}


@Composable fun SecondPage(){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.ghana_meme))
    val progress by animateLottieCompositionAsState(composition = composition)
    Column(
        modifier = Modifier
            .fillMaxSize()

    ){
        LottieAnimation(
            modifier= Modifier
                .size(400.dp)
                .weight(7f),
            composition=composition,
            iterations = LottieConstants.IterateForever,
            speed = 0.4f,
            renderMode = RenderMode.HARDWARE,
        )
        Column(
            modifier= Modifier
                .weight(4.5f)
                .fillMaxSize(2f)
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge ,
                text="Stay in touch with the latest trends"
            )
        }
    }
}


@Composable fun Thirdpage(navController:NavController){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.meet_people))
    val progress by animateLottieCompositionAsState(composition = composition)
    Column(
        modifier = Modifier
            .fillMaxSize()

    ){
        LottieAnimation(
            modifier= Modifier
                .size(400.dp)
                .weight(7f),
            composition=composition,
            iterations = LottieConstants.IterateForever,
            speed = 0.4f,
            renderMode = RenderMode.HARDWARE,
        )
        Column(
            modifier= Modifier
                .weight(4.5f)
                .fillMaxSize(2f)
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge ,
                text="Meet people around and exchange opinions"
            )

            OutlinedButton(onClick = {
                                     navController.navigate(NavigationDestination.News.route)
            }, modifier = Modifier.align(Alignment.End)
            ){
                Text(
                    text="Let's begin", color = Color.White
                )
            }
        }
    }
}