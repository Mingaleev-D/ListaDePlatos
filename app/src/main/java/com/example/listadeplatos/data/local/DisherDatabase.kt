package com.example.listadeplatos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listadeplatos.data.dto.details.MealDetails
import com.example.listadeplatos.data.dto.details.SmallEntityMeal

/**
 * @author : Mingaleev D
 * @data : 06.06.2023
 */

@Database(entities = [SmallEntityMeal::class], version = 1, exportSchema = false)
abstract class DisherDatabase : RoomDatabase() {
   abstract fun dao(): DisherDao
}