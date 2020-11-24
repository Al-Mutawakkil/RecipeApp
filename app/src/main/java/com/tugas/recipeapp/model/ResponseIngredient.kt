package com.tugas.recipeapp.model

import com.google.gson.annotations.SerializedName

data class ResponseIngredient(

	@field:SerializedName("meals")
	val meals: List<IngredientsItem>? = null
)

data class IngredientsItem(

	@field:SerializedName("strDescription")
	val strDescription: String? = null,

	@field:SerializedName("strIngredient")
	val strIngredient: String? = null,

	@field:SerializedName("strType")
	val strType: Any? = null,

	@field:SerializedName("idIngredient")
	val idIngredient: String? = null
)
