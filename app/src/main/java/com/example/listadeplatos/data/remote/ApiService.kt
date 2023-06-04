package com.example.listadeplatos.data.remote

import com.example.listadeplatos.data.dto.CategoryDtoResponse
import retrofit2.http.GET

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

interface ApiService {

   @GET("categories.php")
   suspend fun getAllCategories():CategoryDtoResponse
}