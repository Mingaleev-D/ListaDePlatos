package com.example.listadeplatos.domain.usecase

import com.example.listadeplatos.data.dto.details.DetailsDtoResponse
import com.example.listadeplatos.domain.IDetailRepository
import javax.inject.Inject

/**
 * @author : Mingaleev D
 * @data : 05.06.2023
 */

interface IGetDetailsUseCase {
   suspend operator fun invoke(id: String): DetailsDtoResponse
}

class GetDetailsUseCase @Inject constructor(
    private val repository: IDetailRepository
) : IGetDetailsUseCase {
   override suspend fun invoke(id: String): DetailsDtoResponse {
      return repository.getDetailForDesh(id)
   }
}