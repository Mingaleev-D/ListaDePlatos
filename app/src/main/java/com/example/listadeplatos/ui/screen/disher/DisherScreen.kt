package com.example.listadeplatos.ui.screen.disher

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listadeplatos.data.dto.disher.Meal
import com.example.listadeplatos.ui.screen.category.SingleItem

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

@Composable
fun DisherScreen(
    viewModel: DisherViewModel = hiltViewModel(),
    category: String?,
    onClickedDish: (String) -> Unit
) {

   DisposableEffect(key1 = Unit) {
      if (!category.isNullOrBlank()) {
         viewModel.getDisherForCategory(category)
      }
      onDispose { }
   }
   val viewState by remember {
      viewModel.viewState
   }
   when (val state = viewState) {
      is ViewState.Error -> {
         Text(text = "Disher category: ${state.errMsg}")
      }

      ViewState.Loading -> {
         Text(text = "Loading")
      }

      is ViewState.Success -> {
         //Text(text = "Disher category: ${state.data}")
         DishersList(state.data, onClickedDish)
      }
   }
}

@Composable fun DishersList(meals: List<Meal>, onClickedDish: (String) -> Unit) {
   LazyColumn() {
      items(meals) {item ->
         SingleItem(
             title = item.strMeal,
             imeage = item.strMealThumb,
             onClicked = {
                onClickedDish(item.idMeal)
             }
         )
      }
   }
}