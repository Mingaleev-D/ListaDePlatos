package com.example.listadeplatos.ui.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.listadeplatos.R

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
   val uriHandler = LocalUriHandler.current

   singleDish?.let {
      Column {
         Text(text = it.strMeal)
         Text(text = it.strArea)
         Image(
             modifier = Modifier
                 .size(44.dp)
                 .clickable {
                    viewModel.savetoFavorites(it)
                 },
             painter = painterResource(id = R.drawable.baseline_favorite_border_24),
             contentDescription = null
         )
         Image(
             painter = rememberAsyncImagePainter(model = it.strMealThumb),
             contentDescription = null,
             modifier = Modifier.size(80.dp)
         )
         Text(text = it.strCategory)
         ClickableText(text = AnnotatedString(it.strYoutube),
                       onClick = { _ ->
                          uriHandler.openUri(it.strYoutube)
                       })
         InstructionsTextBlock(instructions = it.strInstructions)
      }

   }
}

@Composable
fun InstructionsTextBlock(
    instructions: String,
    modifier: Modifier = Modifier
) {
   var showMore by remember {
      mutableStateOf(false)
   }
   Column(modifier = modifier.padding(6.dp)) {
      Box(modifier = Modifier
          .`if`(!showMore) {
             height(100.dp)
          }
      )

      Text(text = instructions)

      Button(onClick = { showMore = !showMore }) {
         Text(text = "Show moree...")
      }
   }

}

fun Modifier.`if`(
    condition: Boolean,
    then: Modifier.() -> Modifier
): Modifier =
    if (condition) {
       then()
    } else {
       this
    }