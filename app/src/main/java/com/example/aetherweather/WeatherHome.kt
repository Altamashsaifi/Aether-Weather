package com.example.aetherweather
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.Image

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.layout.ContentScale
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh

import androidx.compose.material3.TextField

import androidx.compose.material3.TextFieldDefaults

import androidx.compose.material3.ButtonDefaults

import androidx.compose.foundation.layout.*

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp

import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherHome(

    vm: WeatherViewModel =
        viewModel()

) {

    LaunchedEffect(Unit) {

        vm.loadWeather()

    }

    Box(

        modifier =

            Modifier
                .fillMaxSize()

                .background(

                    Brush.verticalGradient(

                        when {

                            vm.condition.contains(
                                "sun",
                                true
                            ) ->

                                listOf(

                                    Color(0xFF4A6CFF),

                                    Color(0xFF6CAEFF),

                                    Color(0xFFD7E8FF)

                                )

                            vm.condition.contains(
                                "cloud",
                                true
                            ) ->

                                listOf(

                                    Color(0xFF536976),

                                    Color(0xFF859398),

                                    Color(0xFFD6DBDF)

                                )

                            vm.condition.contains(
                                "rain",
                                true
                            ) ->

                                listOf(

                                    Color(0xFF232526),

                                    Color(0xFF414345),

                                    Color(0xFF768390)

                                )

                            vm.condition.contains(
                                "fog",
                                true
                            ) ->

                                listOf(

                                    Color(0xFF7A7A7A),

                                    Color(0xFFA8A8A8),

                                    Color(0xFFD8D8D8)

                                )
                            vm.condition.contains(
                                "storm",
                                true
                            ) ||

                                    vm.condition.contains(
                                        "thunder",
                                        true
                                    ) ->

                                listOf(

                                    Color(
                                        0xFF141E30
                                    ),

                                    Color(
                                        0xFF243B55
                                    ),

                                    Color(
                                        0xFF556E8A
                                    )

                                )

                            else ->

                                listOf(

                                    Color(0xFF4F86FF),

                                    Color(0xFF7DB9FF),

                                    Color(0xFFE8F3FF)

                                )

                        }

                    )

                ),

        contentAlignment =

            Alignment.TopCenter


    )

    {

        Column(

            modifier =

                Modifier
                    .fillMaxSize()
                    .padding(
                        top = 60.dp
                    ),

            horizontalAlignment =

                Alignment.CenterHorizontally

        )

        {
            Row(

                modifier =

                    Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 24.dp
                        )

            )


            {

                TextField(

                    value =

                        vm.city,

                    onValueChange = {

                        vm.city = it

                    },

                    placeholder = {

                        Text(

                            "Search",

                            color =

                                Color.White.copy(
                                    0.7f
                                )

                        )

                    },

                    singleLine = true,

                    shape =

                        RoundedCornerShape(
                            50.dp
                        ),

                    colors =

                        TextFieldDefaults.colors(

                            focusedContainerColor =

                                Color.White.copy(
                                    0.18f
                                ),

                            unfocusedContainerColor =

                                Color.White.copy(
                                    0.14f
                                ),

                            focusedTextColor =

                                Color.White,

                            unfocusedTextColor =

                                Color.White,

                            focusedIndicatorColor =

                                Color.Transparent,

                            unfocusedIndicatorColor =

                                Color.Transparent,

                            cursorColor =

                                Color.White

                        ),

                    modifier =

                        Modifier
                            .weight(
                                1f
                            )

                )

                Spacer(
                    Modifier.width(
                        12.dp
                    )
                )

                Button(

                    onClick = {

                        vm.loadWeather()

                    },

                    shape =

                        RoundedCornerShape(
                            50.dp
                        ),

                    colors =

                        ButtonDefaults.buttonColors(

                            containerColor =

                                Color.White

                        )


                )


                {


                    Text(

                        "Go",

                        color =

                            Color(
                                0xFF4F86FF
                            )

                    )

                }

            }
            Spacer(
                Modifier.height(
                    120.dp
                )
            )
            Image(

                painter =

                    painterResource(

                        vm.weatherIcon

                    ),

                contentDescription =

                    null,

                modifier =

                    Modifier
                        .size(
                            72.dp
                        ),

                contentScale =

                    ContentScale.Fit

            )

            Spacer(

                Modifier.height(
                    14.dp
                )

            )

            Text(

                vm.city,

                fontSize =
                    34.sp,

                color =
                    Color.White

            )

            Spacer(
                Modifier.height(
                    20.dp
                )
            )

            Text(

                vm.temperature,

                fontSize =
                    96.sp,

                color =
                    Color.White

            )

            Spacer(
                Modifier.height(
                    20.dp
                )
            )

            Card(

                modifier =

                    Modifier
                        .fillMaxWidth(
                            0.85f
                        )
                        .padding(
                            horizontal = 20.dp
                        ),

                colors =

                    CardDefaults.cardColors(

                        containerColor =

                            Color.White.copy(
                                alpha = 0.18f
                            )

                    )

            )


            {
                Spacer(
                    Modifier.height(
                        36.dp
                    )
                )

                LazyRow(

                    horizontalArrangement =

                        Arrangement.spacedBy(
                            12.dp
                        ),

                    contentPadding =

                        PaddingValues(
                            horizontal = 24.dp
                        )

                )

                {

                    items(

                        listOf(

                            Triple(
                                "Now",
                                "☀",
                                "43°"
                            ),

                            Triple(
                                "3 PM",
                                "☀",
                                "42°"
                            ),

                            Triple(
                                "6 PM",
                                "☁",
                                "39°"
                            ),

                            Triple(
                                "9 PM",
                                "☾",
                                "34°"
                            ),

                            Triple(
                                "12 AM",
                                "☾",
                                "31°"
                            )

                        )

                    )


                    {


                            (time,icon,temp)->

                        Card(

                            colors =

                                CardDefaults.cardColors(

                                    containerColor =

                                        Color.White.copy(
                                            0.16f
                                        )

                                )

                        )

                        {

                            Column(

                                modifier =

                                    Modifier
                                        .padding(
                                            18.dp
                                        ),

                                horizontalAlignment =

                                    Alignment.CenterHorizontally

                            )

                            {
                                Text(

                                    icon,

                                    fontSize =

                                        24.sp,

                                    color =

                                        Color.White

                                )

                                Spacer(

                                    Modifier.height(
                                        8.dp
                                    )

                                )

                                Text(

                                    time,

                                    color =
                                        Color.White

                                )

                                Spacer(
                                    Modifier.height(
                                        10.dp
                                    )
                                )

                                Text(

                                    temp,

                                    fontSize =
                                        20.sp,

                                    color =
                                        Color.White

                                )

                            }

                        }

                    }

                }

                Column(

                    modifier =
                        Modifier.padding(
                            24.dp
                        ),

                    horizontalAlignment =
                        Alignment.CenterHorizontally

                )

                {

                    Text(

                        vm.condition,

                        color =
                            Color.White,

                        fontSize =
                            20.sp

                    )
                    Spacer(
                        Modifier.height(
                            10.dp
                        )
                    )

                    Text(

                        "Updated • ${vm.updatedAt}",

                        fontSize =
                            13.sp,

                        color =
                            Color.White.copy(
                                0.75f
                            )

                    )

                }

            }

        }

    }

}