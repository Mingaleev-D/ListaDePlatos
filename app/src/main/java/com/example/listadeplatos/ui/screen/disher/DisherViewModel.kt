package com.example.listadeplatos.ui.screen.disher

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listadeplatos.data.dto.disher.Meal
import com.example.listadeplatos.domain.usecase.IGetDisherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

@HiltViewModel
class DisherViewModel @Inject constructor(
    private val uc: IGetDisherUseCase
) : ViewModel() {

   private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
   val viewState: State<ViewState> = _viewState


   fun getDisherForCategory(catName: String) {
      _viewState.value = ViewState.Loading
      viewModelScope.launch {
         try {
            val listDishes = uc(catName)
            _viewState.value = ViewState.Success(listDishes.meals)
         } catch (ex: Exception) {
            _viewState.value = ViewState.Error(ex.message ?: "Error")
            println(ex.message)
         }
      }
   }
}

sealed class ViewState {
   object Loading : ViewState()
   data class Success(val data: List<Meal>) : ViewState()
   data class Error(val errMsg: String) : ViewState()
}