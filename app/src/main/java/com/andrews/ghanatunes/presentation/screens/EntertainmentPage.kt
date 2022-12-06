package com.andrews.ghanatunes.presentation.screens

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
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrews.ghanatunes.R


@Composable
fun EntertainmentPage(){
    Column(modifier = Modifier
        .padding(vertical = 10.dp)
        .verticalScroll(rememberScrollState())
        .fillMaxSize(40f)) {
        for(i in 1..1000){
            NewsItem()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun NewsItem(){
    Row(
        modifier = Modifier
            .height(90.dp)
            .fillMaxSize()
            .padding(10.dp)
    ){
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20))
                .weight(weight = 6f, fill = true)
                .height(90.dp)
                .fillMaxSize(0.2f)
                .padding(horizontal = 5.dp, vertical = 1.dp),

        ){
            Image(painter = painterResource(id = R.drawable.sample_image),
                contentDescription = "samople",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Column(modifier = Modifier
            .weight(20f)
            .fillMaxSize()
            .padding(horizontal = 4.dp, vertical = 1.dp)

        ){
            Text("Header header header header header Hea der ...",
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(10f).fillMaxWidth(),
                fontSize = 14.sp)
            Box(
                modifier = Modifier.weight(10f).fillMaxSize()
            ){
                Row(
                modifier = Modifier
                    .fillMaxSize()
                ){
                    Text(
                        "4 hours ago",
                        //textAlign = TextAlign.Start,
                        modifier = Modifier.weight(5f)
                            .align(Bottom),
                        color = Color.Gray
                    )
                    Text(
                        "900 views",
                        textAlign = TextAlign.End,
                        modifier = Modifier.weight(5f)
                            .align(Bottom),
                        color = Color.Gray

                    )
                }

            }

        }
    }
}