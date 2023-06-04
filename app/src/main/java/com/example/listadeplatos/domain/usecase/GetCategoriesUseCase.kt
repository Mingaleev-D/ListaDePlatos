package com.example.listadeplatos.domain.usecase

import com.example.listadeplatos.data.dto.CategoryDtoResponse
import com.example.listadeplatos.domain.CategoriesRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */


interface IGetCategoriesUseCase {
   suspend operator fun invoke(): CategoryDtoResponse
}

class GetCategoriesUseCase @Inject constructor(
    val repository: CategoriesRepository
) : IGetCategoriesUseCase {
   override suspend fun invoke(): CategoryDtoResponse {
      return repository.getAllCategories()
   }
}