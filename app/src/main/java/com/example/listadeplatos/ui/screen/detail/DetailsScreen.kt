package com.example.listadeplatos.ui.screen.detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

/**
 * @author : Mingaleev D
 * @data : 05.06.2023
 */

@Composable
fun DetailsScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    mealId: String?,
) {

   DisposableEffect(key1 = Unit) {
      if (!mealId.isNullOrBlank()) {
         viewModel.getDetailsForDishId(mealId)
      }
      onDispose { }
   }
   val singleDish by remember {
      viewModel.viewStateDetails
   }

   singleDish?.let {
      Text(text = it.strMeal)
   }
}