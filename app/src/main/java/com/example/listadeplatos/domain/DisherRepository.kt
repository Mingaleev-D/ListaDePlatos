package com.example.listadeplatos.domain

import com.example.listadeplatos.data.dto.disher.DisherDtoResponse
import com.example.listadeplatos.data.remote.ApiService
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

interface IDisherRepository{

   suspend fun getDisherForCategory(category:String):DisherDtoResponse
}

class DisherRepository @Inject constructor(
    private val api:ApiService
) :IDisherRepository{
   override suspend fun getDisherForCategory(category: String): DisherDtoResponse {
      return api.getDisherForCategory(category)
   }
}