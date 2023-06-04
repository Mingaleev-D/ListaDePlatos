package com.example.listadeplatos.di

import com.example.listadeplatos.data.common.Constants.BASE_URL
import com.example.listadeplatos.data.remote.ApiService
import com.example.listadeplatos.domain.CategoriesRepository
import com.example.listadeplatos.domain.ICategoriesRepository
import com.example.listadeplatos.domain.usecase.GetCategoriesUseCase
import com.example.listadeplatos.domain.usecase.IGetCategoriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

   @Provides
   @Singleton
   fun provideRetrofit(): Retrofit {
      return Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()

   }

   @Provides
   @Singleton
   fun provideApiService(retrofit:Retrofit):ApiService{
      return retrofit.create(ApiService::class.java)
   }

   @Module
   @InstallIn(SingletonComponent::class)
   interface AppModuleInt {

      @Binds
      @Singleton
      fun provideCategoryRepository(repository: CategoriesRepository): ICategoriesRepository

      @Binds
      @Singleton
      fun provideGetCategoryUseCase(us: GetCategoriesUseCase): IGetCategoriesUseCase


   }


}