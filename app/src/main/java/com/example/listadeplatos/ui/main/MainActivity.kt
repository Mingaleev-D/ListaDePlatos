package com.example.listadeplatos.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.listadeplatos.ui.screen.category.CategoryScreen
import com.example.listadeplatos.ui.screen.disher.DisherScreen
import com.example.listadeplatos.ui.theme.ListaDePlatosTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContent {
         ListaDePlatosTheme {
            DeplatosApp()
         }
      }
   }
}

@Composable
fun DeplatosApp() {
   val navController = rememberNavController()
   NavHost(navController = navController, startDestination = "category") {
      composable(route = "category") {
         CategoryScreen() { categoryStr ->
            navController.navigate(route = "dishes/${categoryStr}")
         }
      }
      composable(route = "dishes/{category}", arguments = listOf(
          navArgument(name = "category") {
             type = NavType.StringType
          }
      )) {
         val catStr = remember() { it.arguments?.getString("category") }
         DisherScreen(category = catStr)
      }
   }

}

