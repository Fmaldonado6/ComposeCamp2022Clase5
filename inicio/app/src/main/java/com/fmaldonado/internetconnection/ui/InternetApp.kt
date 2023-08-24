package com.fmaldonado.internetconnection.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fmaldonado.internetconnection.ui.screens.HomeScreen
import com.fmaldonado.internetconnection.ui.screens.HomeViewModel

@Composable
fun InternetApp(modifier: Modifier = Modifier) {

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                modifier = Modifier.height(70.dp),

                title = {
                    Text(
                        "Conexión a Internet",
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Medium)
                    )
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colors.background
        ) {
            val viewModel: HomeViewModel = viewModel()
            HomeScreen(uiState = viewModel.homeUiState)
        }
    }

}