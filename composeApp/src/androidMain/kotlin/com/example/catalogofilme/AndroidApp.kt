package com.example.catalogofilme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import AppNavGraph

@Composable
fun AndroidApp() {
    val navController = rememberNavController()
    AppNavGraph(navController)
}