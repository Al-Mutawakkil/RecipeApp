package com.tugas.recipeapp.service

import com.tugas.recipeapp.model.ResponseMeals
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuilder {

    private val client: OkHttpClient = OkHttpClient.Builder().build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.themealdb.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getService() = retrofit.create(RecipeList::class.java)

}

    interface RecipeList{
        @GET("api/json/v1/1/search.php?f=b")

        fun fetchList(): Call<ResponseMeals>
    }