package com.example.weathercompose.ui.compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.R
import com.example.weathercompose.feature.weather_screen.ui.WeatherScreenViewModel
import com.example.weathercompose.ui.theme.DarkGray
import org.koin.androidx.compose.getViewModel




@Preview(showBackground = true)
@Composable
fun MainScreen() {
    Image(
        painter = painterResource(id = R.drawable.weather),
        contentDescription = "img1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.6f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            backgroundColor = DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.38f)
                .alpha(0.8f)
                .padding(vertical = 8.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(10.dp),
        ) {
            CurrentCardItem()
        }
        Card(
            backgroundColor = DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.18f)
                .alpha(0.8f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14) ){
                    index, item ->
                    ForecastHoursItem()
                }
            }

        }
//        Card(
//            backgroundColor = DarkGray,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .alpha(0.8f)
//                .padding(vertical = 8.dp),
//            shape = RoundedCornerShape(10.dp)
//        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    ,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                itemsIndexed(listOf(1, 2, 3,4,5,6,7,8,9,10,11,12,13,14)) { index, item ->
                    ForecastItem()
                }
            }

//        }

    }
}

