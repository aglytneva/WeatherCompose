package com.example.weathercompose.ui.compose

import android.location.LocationManager
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weathercompose.R
import com.example.weathercompose.feature.weather_screen.ui.WeatherScreenViewModel
import org.koin.androidx.compose.getViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import com.example.weathercompose.feature.weather_screen.ui.DataEvent
import com.example.weathercompose.feature.weather_screen.ui.UiEvent
import com.example.weathercompose.ui.theme.MarkPro

@Preview(showBackground = true)
@Composable
fun CurrentCardItem(
    viewModel: WeatherScreenViewModel = getViewModel()
) {


    val viewState = viewModel.viewState.observeAsState()

    var city by rememberSaveable { mutableStateOf("Moscow") }
    viewModel.processDataEvent(DataEvent.WeatherIsLoaded(city))
    viewModel.processDataEvent(DataEvent.WeatherDaysIsLoaded(city))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .alpha(1f),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.12f)
                .padding(start = 10.dp, end = 10.dp)
                .alpha(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            //???????????????? ?????????????? ????????
            Text(
                text = "?????????????? ${viewState.value!!.currentDay}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = MarkPro
            )
            //???????????????? ????????????
            Text(
                text = viewState.value!!.city.capitalize(), color = Color.White, fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MarkPro
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.78f)
                .alpha(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = viewState.value!!.tempCurrent,
                        color = Color.White,
                        fontSize = 64.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MarkPro
                    )
                    Image(
                        painter = rememberImagePainter(
                            "http://openweathermap.org/img/wn/${viewState.value!!.iconCurrent}@2x.png"
                        ),
                        contentDescription = "imgCurrentcard",
                        modifier = Modifier
                            .size(110.dp)
                            .alpha(1f)
                    )
                }
                Row() {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_switch_access_shortcut_add_24),
                        contentDescription = "imgWind",
                        modifier = Modifier.size(24.dp),
                    )
                    Text(
                        text = viewState.value!!.windDegCurrent,
                        color = Color.White, fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = MarkPro
                    )
//                    Text(text = viewState.value!!., color = Color.White, fontSize = 20.sp)
                }
                Text(
                    text = viewState.value!!.descriptionCurent,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = MarkPro
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            IconButton(
                modifier = Modifier
                    .fillMaxHeight(),
                onClick = {
                    viewModel.processUiEvent(UiEvent.isSearchClicked)
                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_search_24),
                    contentDescription = "imSearch",
                    tint = Color.White,
                    modifier = Modifier.fillMaxHeight()
                )

            }
            if (viewState.value!!.isSearchVisible) {
                TextField(
                    value = city,
                    onValueChange = {
                        city = it
                    },
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.White,
                        fontFamily = MarkPro
                    ),
                    modifier = Modifier
                        .width(IntrinsicSize.Min)
                )
            }

            IconButton(
                modifier = Modifier
                    .fillMaxHeight(),
                onClick = {
                    viewModel.processUiEvent(UiEvent.isUpdatStateButtonCkicked)

                }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_refresh_24),
                    contentDescription = "imSearch",
                    tint = Color.White,
                )
            }
        }
    }

}