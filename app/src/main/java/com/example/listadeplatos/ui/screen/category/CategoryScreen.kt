package com.example.listadeplatos.ui.screen.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.listadeplatos.data.dto.Category
import com.example.listadeplatos.ui.theme.ListaDePlatosTheme

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

@Composable
fun CategoryScreen(
    viewmodel: CategoryViewModel = hiltViewModel(),
    onItemClick: (String) -> Unit
) {

   val listOfCategories by remember {
      viewmodel.listOfCategory
   }

   Column {
      Text(text = "Category")
      Spacer(modifier = Modifier.height(30.dp))
      LazyColumn() {
         items(listOfCategories) {
            SingleItem(
                title = it.strCategory,
                imeage = it.strCategoryThumb
            ) { strCategory ->
               onItemClick(strCategory)
            }
         }
      }
   }
}

@Composable
fun SingleItem(
    title: String,
    imeage: String,
    onClicked: (String) -> Unit
) {
   Card(
       modifier = Modifier
           .padding(8.dp)
           .fillMaxWidth()
           .clickable { onClicked(title) },
       elevation = 4.dp
   ) {
      Row(modifier = Modifier.padding(6.dp), verticalAlignment = Alignment.CenterVertically) {
         Image(
             painter = rememberAsyncImagePainter(model = imeage),
             contentDescription = null,
             modifier = Modifier.size(80.dp)
         )
         Text(text = title, fontSize = 24.sp)
      }
   }

}

@Preview
@Composable
fun PreviewCategoryScreen() {
   ListaDePlatosTheme {
      //      CategoryScreen(){
      //
      //      }
   }
}