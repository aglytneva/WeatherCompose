package com.example.weathercompose.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weathercompose.R
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel
import com.example.weathercompose.ui.theme.MarkPro
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter


@Composable
fun ForecastHoursItem(item: WeatherMainModel) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(70.dp)
            .alpha(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            text = item.time,
            fontSize = 16.sp,
            color = Color.White,
            lineHeight = 12.sp,
            modifier = Modifier
                .fillMaxHeight(0.2f)
                .padding(top = 4.dp)
                .alpha(1f),
            fontFamily = MarkPro
        )
        Text(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            text = item.weekDay,
            fontSize = 16.sp,
            color = Color.White,
            lineHeight = 12.sp,
            modifier = Modifier
                .fillMaxHeight(0.2f)
                .padding(top = 4.dp)
                .alpha(1f),
            fontFamily = MarkPro
        )
        Image(
            painter = rememberImagePainter(
                "http://openweathermap.org/img/wn/${item.icon}@2x.png"
            ),
            contentDescription = "ImgHoursWeather",
            modifier = Modifier
                .size(60.dp)
                .padding(0.dp)
                .fillMaxHeight(0.5f)
                .alpha(1f),
            contentScale = ContentScale.Crop
        )
        Text(
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            text = "${item.temperature.toInt()}°",
            color = Color.White,
            lineHeight = 4.sp,
            modifier = Modifier.fillMaxHeight()
                .padding(4.dp)
                .alpha(1f),
            fontSize = 20.sp,
            fontFamily = MarkPro

        )
    }
}
