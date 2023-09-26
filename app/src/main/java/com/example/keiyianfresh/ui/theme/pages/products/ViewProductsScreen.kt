package com.example.augustmoringnavigationapp.ui.theme.pages.products

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.augustmoringnavigationapp.data.ProductRepository
import com.example.augustmoringnavigationapp.models.Product
import com.example.augustmoringnavigationapp.navigation.ROUTE_UPDATE_PRODUCTS


@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun ViewProductsScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var productRepository = ProductRepository(navController, context)


        val emptyProductState = remember { mutableStateOf(Product("","","","")) }
        var emptyProductsListState = remember { mutableStateListOf<Product>() }

        var products = productRepository.viewProducts(emptyProductState, emptyProductsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = "All Products",
                color = Color.Blue,
                fontSize = 30.sp,
                modifier = Modifier.padding(20.dp)
            )
        }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(products){
                    ProductItem(
                        name = it.name,
                        quantity = it.quantity,
                        price = it.price,
                        id = it.id,
                        navController = navController,
                        productRepository = productRepository
                    )
                }
            }
        }
    }
}


@Composable
fun ProductItem(name:String, quantity:String, price:String, id:String,
                navController:NavHostController, productRepository:ProductRepository) {
    var context = LocalContext.current

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = name)
        Text(text = quantity)
        Text(text = price)

//start of row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = {
                productRepository.deleteProduct(id)
            }, colors = ButtonDefaults.buttonColors(Color.White)) {
                Text(text = "Delete")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {
                navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
            }, colors = ButtonDefaults.buttonColors(Color.White)) {
                Text(text = "Update")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {    val simToolKitLaunchIntent: Intent? = context.getPackageManager()
                .getLaunchIntentForPackage("com.android.stk")
                if (simToolKitLaunchIntent != null) {
                    context.startActivity(simToolKitLaunchIntent)
                }},
                colors = ButtonDefaults.buttonColors(Color.Green)) {
                Text(text = "Pay")

            }
        }

//        end of row


    }
}