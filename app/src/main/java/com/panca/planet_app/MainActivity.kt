package com.panca.planet_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.panca.planet_app.feature.home.view.HomePage
import com.panca.planet_app.ui.theme.Planet_appTheme
import com.panca.planet_app.ui.theme.fontFamily

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Planet_appTheme {

                MainApp()


            }
        }
    }
}

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "getting_started") {
        composable(route = "getting_started") {
            GettingStarted(navController)
        }
        composable(
            route = "home_page"
        ) {
            HomePage()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalCoilApi
@Composable
fun GettingStarted(navController: NavHostController) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    // A surface container using the 'background' color from the theme

    Scaffold(scaffoldState = scaffoldState, topBar = { }) {
        Box {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.onboarding_screen),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                Arrangement.Bottom,
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 24.dp),

                    ) {
                    GetStartedContent(navController)
                }
            }
        }
    }
}

@Composable
private fun GetStartedContent(navController: NavHostController) {

    Box(

        modifier = Modifier.background(
            color = Color.White, shape = RoundedCornerShape(size = 24.dp)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Hello!", style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = fontFamily, fontWeight = FontWeight.Black,
                    color = Color(0xFF333333),

                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Want to know and explore all things about the planets in the Milky Way galaxy?",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = fontFamily,
                    color = Color(0xFF7B7A7A),

                    textAlign = TextAlign.Center,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate("home_page") },
                Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(size = 24.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        0xFFEB5757
                    ),
                ),
            ) {
                Text(
                    text = "Explore Now", style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 31.sp,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight(500),
                        color = Color(0xFFFFFFFF),

                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}

@Composable
private fun SplashScreenAppBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Home,
                modifier = Modifier.padding(horizontal = 12.dp),
                contentDescription = "Action icon"
            )
        },
        title = { Text(stringResource(R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.background
    )
}

@Preview(showBackground = true)
@Composable
fun BodyPreview() {
    Planet_appTheme {
//        GettingStarted()
    }
}