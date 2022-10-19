package com.example.weathercompose.compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.DarkGray


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
                .fillMaxHeight(0.3f)
                .alpha(0.6f)
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
                .fillMaxHeight()
                .alpha(0.7f),
            shape = RoundedCornerShape(10.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                itemsIndexed(listOf(1, 2, 3)) { index, item ->
                    ForecastItem()
                }
            }

        }

    }
}