package com.andrews.ghanatunes.screens

import android.media.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrews.ghanatunes.R

@Preview(showBackground = true)
@Composable
fun EntertainmentPage(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
        NewsItem()
    }
}

@Preview(showBackground = true)
@Composable
fun NewsItem(){
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxSize()
            .padding(5.dp)
    ){
        Image(painter = painterResource(id = R.drawable.sample_image),
            contentDescription = "samople",
            modifier = Modifier
                .weight(2f)
                .fillMaxSize(2f)
                .clip(RoundedCornerShape(15))
                .padding(horizontal = 5.dp, vertical = 1.dp),
            contentScale = ContentScale.None
        )
        Row(modifier = Modifier
            .weight(8f)
            .padding(horizontal = 4.dp, vertical = 1.dp)){
            Text("Header header header header header Header header header header header ",
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Start,

                fontSize = 14.sp)
            Column() {

            }
        }
    }
}