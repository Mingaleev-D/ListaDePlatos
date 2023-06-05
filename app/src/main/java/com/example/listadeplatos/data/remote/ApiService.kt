package com.example.listadeplatos.data.remote

import com.example.listadeplatos.data.dto.CategoryDtoResponse
import com.example.listadeplatos.data.dto.disher.DisherDtoResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author : Mingaleev D
 * @data : 04.06.2023
 */

interface ApiService {

   @GET("categories.php")
   suspend fun getAllCategories():CategoryDtoResponse

   @GET("filter.php")
   suspend fun getDisherForCategory(
       @Query("c") disherName:String
   ): DisherDtoResponse
}