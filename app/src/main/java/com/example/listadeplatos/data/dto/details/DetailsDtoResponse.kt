package com.example.listadeplatos.data.dto.details


import com.google.gson.annotations.SerializedName

data class DetailsDtoResponse(
    @SerializedName("meals")
    val meals: List<MealDetails>
)