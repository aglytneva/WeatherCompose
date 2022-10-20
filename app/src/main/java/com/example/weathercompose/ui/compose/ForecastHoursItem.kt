package com.example.weathercompose.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercompose.R

@Preview(showBackground = true)
@Composable
fun ForecastHoursItem() {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(40.dp)
                ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Сейчас", fontSize = 10.sp, color = Color.White)
            Image (
                painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                contentDescription = "ImgHoursWeather",
                colorFilter = ColorFilter.tint(Color.Yellow)
            )
            Text (text = "15°",  color = Color.White)
        }
    }
