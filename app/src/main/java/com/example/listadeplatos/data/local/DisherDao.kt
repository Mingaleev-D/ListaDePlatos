package com.example.listadeplatos.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listadeplatos.data.dto.details.MealDetails
import com.example.listadeplatos.data.dto.details.SmallEntityMeal

/**
 * @author : Mingaleev D
 * @data : 06.06.2023
 */

@Dao
interface DisherDao {

   @Query("SELECT * FROM mealDetail_table")
   suspend fun getListOfString():List<SmallEntityMeal>

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun saveMeal(meal:SmallEntityMeal)
}