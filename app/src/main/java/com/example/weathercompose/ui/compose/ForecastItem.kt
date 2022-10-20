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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathercompose.R
import com.example.weathercompose.ui.theme.DarkGray
import com.example.weathercompose.ui.theme.LightGray

@Preview(showBackground = true)
@Composable
fun ForecastItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.8f)
            .padding(top = 4.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = DarkGray,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(text = "17.10", color = Color.White, fontSize = 14.sp)
                Text(text = "ПН", color = Color.White, fontSize = 14.sp)
            }
            Text(text = "Пасмурно", color = Color.White, fontSize = 14.sp)
//            Text(text = "", color = Color.White, fontSize = 14.sp)
            Text(text = "15°С", color = Color.White, fontSize = 24.sp)
            Image(
                painter = painterResource(R.drawable.ic_baseline_wb_sunny_24),
                colorFilter = ColorFilter.tint(Color.Yellow),
                contentDescription = "img3",
            )
        }
    }
}