package com.example.augustmoringnavigationapp.ui.theme.pages.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.augustmoringnavigationapp.navigation.ROUTE_ADD_PRODUCTS
import com.example.augustmoringnavigationapp.navigation.ROUTE_VIEW_PRODUCTS
import com.example.keiyianfresh.R
import com.example.keiyianfresh.ui.theme.KeiyianFreshTheme
@Composable
fun HomeScreen(navController: NavHostController) {


    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "Karibu Keiyian",
                color = Color.Blue,
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp)
            )
        }


        Spacer(modifier = Modifier.height(15.dp))


        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .height(110.dp)
                .width(210.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),


            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Pure\n" +
                            "nourishment",
                    color = Color.White,
                    fontSize = 25.sp,
                )
                Text(
                    text = "With a lot of care and state of the art technology, we bring you and your family pure & fresh nourishment.\n" +
                            "\n" +
                            "We know how important milk is for you and with our products, you can enjoy the wholesome goodness of milk whenever you want.",
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(17.dp))



                Text(
                    text = "Live Life\n" +
                            "to the fullest",
                    color = Color.White,
                    fontSize = 25.sp,
                )
                Text(
                    text = "Keiyian Milk is naturally rich in calcium, vitamins and proteins that we need to strengthen bones, build muscles, nourish children, rejuvenate elders and give us a lifetime of wellbeing.\n" +
                            "\n" +
                            "We are proud to be there for the whole family, every day. From early morning breakfast to the wholesome snack on-the-go, from school break to office meetings and finally unwinding with chai when everyone gets home.\n" +
                            "\n",
                    color = Color.Black,
                )

            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    navController.navigate(ROUTE_ADD_PRODUCTS)
                },
                modifier = Modifier
                    .height(45.dp)
                    .width(170.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(
                    text = "Add milk variety",
                    color = Color.White,
                    fontSize = 15.sp,

                    )
            }
            Spacer(modifier = Modifier.width(15.dp))

            Button(
                onClick = {
                    navController.navigate(ROUTE_VIEW_PRODUCTS)
                },
                modifier = Modifier
                    .height(45.dp)
                    .width(170.dp),
                shape =CircleShape,
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(
                    text = "View milk variety",
                    color = Color.White,
                    fontSize = 15.sp,

                    )
            }
        }


    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreview() {
    KeiyianFreshTheme {
        HomeScreen(rememberNavController())
    }


}

