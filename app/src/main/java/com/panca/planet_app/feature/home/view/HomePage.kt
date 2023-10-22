package com.panca.planet_app.feature.home.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.panca.planet_app.R
import com.panca.planet_app.ui.theme.Planet_appTheme
import com.panca.planet_app.ui.theme.background
import com.panca.planet_app.ui.theme.fontFamily


@Composable
fun HomePage(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Box(
        modifier = modifier
            .background(color = background)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Header(modifier = modifier)
            Spacer(modifier = Modifier.height(height = 8.dp))
            MostPopular(modifier = modifier)
            Spacer(modifier = Modifier.height(height = 32.dp))
            RecommendationPlanet()
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    val state = remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = modifier.padding(all = 24.dp)) {
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(
                    text = "Let’s Explore", style = TextStyle(
                        fontSize = 38.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                    )
                )
                Text(
                    text = "The milky way galaxy", style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFBDBDBD),
                    )
                )
            }
            Image(
                painter = painterResource(id = R.drawable.earth),
                contentDescription = "",
                modifier
                    .width(width = 56.dp)
                    .height(height = 56.dp)
            )
        }
        Spacer(modifier = Modifier.height(height = 32.dp))
        SearchPlanet(state)
    }
}

@Composable
fun SearchPlanet(state: MutableState<TextFieldValue>) {
    Box {

        TextField(label = {
            Text(
                text = "Search for your favorite planet", style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.8.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFF2F2F2),
                )
            )
        }, modifier = Modifier
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(size = 8.dp),
                color = Color(0xFF3A3A4F),
            ), colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),

            value = state.value, onValueChange = { state.value = it }, leadingIcon = {

                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "",
                    tint = Color(0xFFF2F2F2)
                )
            } // Other parameters
        )
    }
}

@Composable
private fun MostPopular(
    modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }
) {

    Column(modifier) {
        Row(modifier.padding(start = 24.dp)) {
            Text(
                text = "Most Popular", style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 26.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(800),
                    color = Color(0xFFFFFFFF),
                )
            )
            Spacer(modifier = Modifier.width(width = 8.dp))
            Icon(
                painter = painterResource(id = R.drawable.arrow_right),

                contentDescription = "", tint = Color.White
            )
        }
        Spacer(modifier = Modifier.height(height = 12.dp))
        LazyRow(
            modifier = Modifier
                .background(color = background)
                .fillMaxWidth()
        ) {
            items(items = names) { name ->
                PlanetCard(name = name)
            }
        }
    }
}

@Composable
fun RecommendationPlanet(
    modifier: Modifier = Modifier, names: List<String> = List(1000) { "$it" }
) {
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "You may also like", color = Color.White,
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 26.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight(800),
                ),
            )
            Row {
                Text(
                    text = "See All", color = Color.White, lineHeight = 8.12.em,
                    style = TextStyle(
                        fontFamily = fontFamily, fontSize = 16.sp, fontWeight = FontWeight.Medium
                    ),
                )
                Spacer(modifier = Modifier.width(width = 4.dp))
                Image(
                    painter = painterResource(id = R.drawable.arrow_right),
                    contentDescription = "Arrow - Left",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
        }
        Spacer(modifier = Modifier.height(height = 12.dp))
        LazyRow(
            modifier = Modifier
                .background(color = background)
                .fillMaxWidth()
        ) {
            items(items = names) { name ->
                PlanetCard(name = name, modifier = modifier, size = 95.dp)
            }
        }
    }
}

@Composable
fun PlanetCard(name: String, modifier: Modifier = Modifier, size: Dp = 156.dp) {

    Row {
        Spacer(modifier = Modifier.width(if (name == "0") 24.dp else 16.dp))
        Box(
            modifier = modifier.background(
                brush = Brush.linearGradient(
                    0f to Color(0xffffd25b),
                    1f to Color(0xffff7a00),
                    start = Offset(211f, 0f),
                    end = Offset(11f, 283.29f)
                ), shape = RoundedCornerShape(24.dp)
            )
        ) {
            Column(
                modifier = modifier.padding(horizontal = 20.dp, vertical = 30.dp)
            ) {

                Image(
                    modifier = modifier
                        .width(size)
                        .height(size),
                    painter = painterResource(id = R.drawable.pluto),
                    contentDescription = "",
                )
                Spacer(modifier = modifier.height(18.dp))

                Text(
                    text = "Pluto", style = TextStyle(
                        fontSize = 28.sp,
                        lineHeight = 36.4.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFFFFFFFF),

                        ), modifier = modifier
                )
                if (size == 156.dp) {
                    Text(
                        text = "The minor planet", style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 23.4.sp,
                            fontFamily = fontFamily,
                            fontWeight = FontWeight(500),
                            color = Color(0xB2FFFFFF),
                        )
                    )
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Planet_appTheme {
        HomePage()
    }
}