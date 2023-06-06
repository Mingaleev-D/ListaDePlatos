package com.example.listadeplatos.domain

import com.example.listadeplatos.data.dto.details.DetailsDtoResponse
import com.example.listadeplatos.data.remote.ApiService
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 05.06.2023
 */


interface IDetailRepository {
   suspend fun getDetailForDesh(mealId: String): DetailsDtoResponse
}

class DetailRepository @Inject constructor(
    val api: ApiService
) : IDetailRepository {
   override suspend fun getDetailForDesh(mealId: String): DetailsDtoResponse {
      return api.getDetailForDesh(mealId)
   }
}