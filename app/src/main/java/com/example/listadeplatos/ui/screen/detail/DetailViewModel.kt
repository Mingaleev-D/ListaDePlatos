package com.example.listadeplatos.ui.screen.detail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeplatos.data.dto.details.MealDetails
import com.example.listadeplatos.domain.usecase.IGetDetailsUseCase
import com.example.listadeplatos.ui.screen.disher.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 05.06.2023
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val usecase: IGetDetailsUseCase
) : ViewModel() {

   private val _viewStateDetails: MutableState<MealDetails?> = mutableStateOf(null)
   val viewStateDetails: State<MealDetails?> = _viewStateDetails

   fun getDetailsForDishId(id: String) {
      viewModelScope.launch {
         try {
            val mealDetail = usecase(id)
            _viewStateDetails.value = mealDetail.meals[0]
         } catch (ex: Exception) {
            println(ex.message)
         }
      }
   }
}