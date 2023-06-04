package com.example.listadeplatos.domain

import com.example.listadeplatos.data.dto.CategoryDtoResponse
import com.example.listadeplatos.data.remote.ApiService
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

interface ICategoriesRepository {
   suspend fun getAllCategories(): CategoryDtoResponse
}

class CategoriesRepository @Inject constructor(
    val api: ApiService
) : ICategoriesRepository {
   override suspend fun getAllCategories(): CategoryDtoResponse {
      return api.getAllCategories()
   }
}