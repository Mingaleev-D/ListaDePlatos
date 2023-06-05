package com.example.listadeplatos.data.dto.disher


import com.google.gson.annotations.SerializedName

data class DisherDtoResponse(
    @SerializedName("meals")
    val meals: List<Meal>
)