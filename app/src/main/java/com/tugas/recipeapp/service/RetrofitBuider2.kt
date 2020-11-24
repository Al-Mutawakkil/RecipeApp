package com.tugas.recipeapp.service

import com.tugas.recipeapp.model.ResponseIngredient
import com.tugas.recipeapp.model.ResponseMeals
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object RetrofitBuilder2 {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(RecipeList2::class.java)

}

    interface RecipeList2{
        @GET("/api/json/v1/1/list.php?i=list")

        fun fetchList(): Call<ResponseIngredient>
    }