package com.example.augustmoringnavigationapp.ui.theme.pages.about

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.keiyianfresh.ui.theme.KeiyianFreshTheme

@Composable
fun AboutScreen(navController:NavHostController) {
    Text(text = "Get affordable Products at affordable price")
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AboutScreenPreview() {
    KeiyianFreshTheme {
        AboutScreen(rememberNavController())
    }
}

