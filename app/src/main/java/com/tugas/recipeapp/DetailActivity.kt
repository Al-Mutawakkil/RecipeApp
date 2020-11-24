package com.tugas.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import com.tugas.recipeapp.databinding.ActivityDetailBinding
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    companion object {
        const val meals = "meals"
        const val category = "category"
        const val area = "area"
        const val instructions = "instructions"
        const val image = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val meals = intent.getStringExtra(meals)
        val category = intent.getStringExtra(category)
        val area = intent.getStringExtra(area)
        val instructions = intent.getStringExtra(instructions)
        val imgDetail = intent.getStringExtra(image)

        tvMeals.text = meals
        tvCategory.text = category
        tvArea.text = area
        tvInstructions.text = instructions
        imageDetail.load(imgDetail)

    }
}