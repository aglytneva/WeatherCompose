package com.example.weathercompose.ui.compose

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weathercompose.R
import com.example.weathercompose.feature.weather_screen.ui.model.WeatherMainModel
import com.example.weathercompose.ui.theme.DarkGray
import com.example.weathercompose.ui.theme.LightGray
import com.example.weathercompose.ui.theme.MarkPro
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun ForecastItem(item: WeatherMainModel) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .alpha(0.8f)
            .padding(top = 10.dp),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = DarkGray,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .alpha(1f)
                .fillMaxSize()
                ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.15f)
                    .fillMaxHeight()
                    .alpha(1f)
            )
            {
                //Дата
                Text(
                    text = item.numberMonthDay,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MarkPro
                )
                // День недели
                Text(
                    text = item.weekDay,
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MarkPro
                )
            }
            // Описание погоды
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.55f)
                    .fillMaxHeight()
                    .padding(start = 8.dp)
                    .alpha(1f)
            )
            {
                Text(
                    text = item.description,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left,
                    softWrap = false,
                    fontFamily = MarkPro
                )
            }
            // Температура
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .fillMaxHeight()
                    .alpha(1f),
                )
            {
                Text(
                    text = "${item.temperature.toInt()}°",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = MarkPro
                    )
            }
            // Картинка
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .alpha(1f)
            )
            {

                Image(
                    painter = rememberImagePainter(
                        "http://openweathermap.org/img/wn/${item.icon}@2x.png",

                        ),
                    contentDescription = "ImgHoursWeather",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(end = 4.dp)
                        .fillMaxSize()
                        .alpha(1f),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}