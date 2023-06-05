package com.example.listadeplatos.domain.usecase

import com.example.listadeplatos.data.dto.disher.DisherDtoResponse
import com.example.listadeplatos.domain.DisherRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

interface IGetDisherUseCase {
   suspend operator fun invoke(categoryName:String): DisherDtoResponse
}

class GetDisherUseCase @Inject constructor(
    private val repository: DisherRepository
) : IGetDisherUseCase {
   override suspend fun invoke(categoryName:String): DisherDtoResponse {
      return repository.getDisherForCategory(categoryName)
   }
}