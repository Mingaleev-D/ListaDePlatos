package com.example.listadeplatos.ui.screen.category

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeplatos.data.dto.Category
import com.example.listadeplatos.domain.usecase.IGetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val usecase: IGetCategoriesUseCase
) : ViewModel() {

   private val _listOfCategory: MutableState<List<Category>> = mutableStateOf(emptyList())
   val listOfCategory: State<List<Category>> = _listOfCategory

   init {
      viewModelScope.launch {
         //val usecase1 = usecase()
         _listOfCategory.value = usecase().categories
      }
   }
}