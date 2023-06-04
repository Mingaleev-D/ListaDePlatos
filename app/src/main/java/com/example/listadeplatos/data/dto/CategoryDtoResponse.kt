package com.example.listadeplatos.data.dto


import com.google.gson.annotations.SerializedName

data class CategoryDtoResponse(
    @SerializedName("categories")
    val categories: List<Category>
)