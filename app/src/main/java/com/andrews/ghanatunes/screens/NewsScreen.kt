package com.andrews.ghanatunes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrews.ghanatunes.R

@Preview(showBackground = true)
@Composable
fun NewsScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
       Text(
           text = "Discover",
           modifier = Modifier.fillMaxWidth(),
           textAlign = TextAlign.Start,
           fontSize = 35.sp,
           fontStyle = FontStyle.Normal,
           fontWeight = FontWeight.ExtraBold
       )
        Text(
            text = "News around your favourite continent",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 20.dp),
            textAlign = TextAlign.Start,
            fontSize = 10.sp,
            color = Color.Gray,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,

        )
        SearchBar()
        TabRows()


    }
}

@Preview(showBackground = true)
@Composable
fun TabRows(){
    val tabs = listOf<String>("Entertainment", "Sports", "Politics", "Tourism")
    var state by remember{mutableStateOf(0)}
    ScrollableTabRow(selectedTabIndex = 1, backgroundColor = Color.White, modifier =  Modifier.padding(20.dp)){
        tabs.forEachIndexed { index, s ->
            Tab(selected = state == index,
                onClick = { TODO()},
                text = {Text(text=s)})

        }
    }
}


@Composable
fun SearchBar(){

        Box(modifier = Modifier
            .height(60.dp)
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color(0xffF5F5F5))){
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp)
                .align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "Search icon",
                    modifier = Modifier
                        .size(50.dp)

                        )
                Text("Search", fontSize = 20.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxSize(20f)
                        .padding(top = 5.dp),
                )
            }
        }
}