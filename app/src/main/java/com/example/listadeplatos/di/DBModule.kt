package com.example.listadeplatos.di

import android.content.Context
import androidx.room.Room
import com.example.listadeplatos.data.local.DisherDao
import com.example.listadeplatos.data.local.DisherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DBModule {

   @Provides
   @Singleton
   fun provideDB(@ApplicationContext context: Context) = Room.databaseBuilder(
       context,
       DisherDatabase::class.java,
       "disher_db"
   ).build()

   @Provides
   @Singleton
   fun provideDBDao(db: DisherDatabase): DisherDao {
      return db.dao()
   }
}