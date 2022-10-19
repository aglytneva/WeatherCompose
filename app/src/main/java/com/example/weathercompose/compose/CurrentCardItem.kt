package com.example.weathercompose.compose

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
fun CurrentCardItem() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Дата", color = Color.White)
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                contentDescription = "img2",
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color.Yellow)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Пасмурно", color = Color.White, fontSize =20.sp)
                Text(text = "15°С", color = Color.White, fontSize =64.sp)
                Text(text = "Город", color = Color.White, fontSize =20.sp)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Поиск города", color = Color.White)
            Text(text = "Hello", color = Color.White)
        }
    }

}