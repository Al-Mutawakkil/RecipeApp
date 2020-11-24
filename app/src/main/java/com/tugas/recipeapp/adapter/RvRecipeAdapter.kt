package com.tugas.recipeapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.size.Scale
import com.tugas.recipeapp.DetailActivity
import com.tugas.recipeapp.R
import com.tugas.recipeapp.databinding.ListResepBinding
import com.tugas.recipeapp.model.MealsItem
import java.util.ArrayList


class RvRecipeAdapter: RecyclerView.Adapter<CdvRecipeList>() {

    private val listRecipe: ArrayList<MealsItem> = arrayListOf<MealsItem>()

    fun addData(items: List<MealsItem>) {
        listRecipe.clear()
        listRecipe.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvRecipeList {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListResepBinding.inflate(layoutInflater, parent, false)
        return CdvRecipeList(binding)
    }

    override fun getItemCount(): Int {
        return listRecipe.size
    }

    override fun onBindViewHolder(holder: CdvRecipeList, position: Int) {
        val data = listRecipe[position]
        holder.bind(data)
        holder.itemView.setOnClickListener {
            val intentDetail = Intent(it.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.meals, data.strMeal)
            intentDetail.putExtra(DetailActivity.area, data.strArea)
            intentDetail.putExtra(DetailActivity.category, data.strCategory)
            intentDetail.putExtra(DetailActivity.instructions, data.strInstructions)
            intentDetail.putExtra(DetailActivity.image, data.strMealThumb)
            it.context.startActivity(intentDetail)
        }
    }

}

class CdvRecipeList(private val binding: ListResepBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MealsItem) {
        with(binding) {
            txtMeals.text = item.strMeal
            imageFood.load(item.strMealThumb){
                scale(Scale.FILL)
            }
        }
    }

}
