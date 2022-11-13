package com.example.weathercompose.ui.compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.R
import com.example.weathercompose.feature.weather_screen.ui.DataEvent
import com.example.weathercompose.feature.weather_screen.ui.WeatherScreenViewModel
import com.example.weathercompose.ui.theme.DarkGray
import org.koin.androidx.compose.getViewModel


@Preview(showBackground = true)
@Composable
fun MainScreen(viewModel: WeatherScreenViewModel = getViewModel()) {
    val viewState = viewModel.viewState.observeAsState()

    //фон
    Image(
        painter = painterResource(id = R.drawable.clouds),
        contentDescription = "img1",
        modifier = Modifier
            .fillMaxSize()
            .alpha(0.8f),
        contentScale = ContentScale.FillBounds
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //Карточка текущей погоды
        Card(
            backgroundColor = DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.38f)
                .alpha(0.7f)
                .padding(vertical = 8.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(10.dp),
        ) {
            CurrentCardItem()
        }
        //Карточка погоды по часам
        Card(
            backgroundColor = DarkGray,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .alpha(0.7f)
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(4.dp)
                    .alpha(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(
                    viewState.value!!.weatherHourForecastList
                ) { index, item ->
                    ForecastHoursItem(item)
                }
            }

        }
        //Отображение погоды по дням
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            itemsIndexed(
                viewState.value!!.weatherDayForecastList
            ) { index, item ->
                ForecastItem(item)
            }
        }

//        }

    }
}

