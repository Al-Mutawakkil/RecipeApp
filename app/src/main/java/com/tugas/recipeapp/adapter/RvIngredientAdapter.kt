package com.tugas.recipeapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugas.recipeapp.R
import com.tugas.recipeapp.databinding.ListIngredientBinding
import com.tugas.recipeapp.model.IngredientsItem

class RvIngredientAdapter: RecyclerView.Adapter<CdvIngredientlist>() {

    private val listIngredient: ArrayList<IngredientsItem> = arrayListOf<IngredientsItem>()
    private val limit:Int = 10

    fun addData(item: List<IngredientsItem>) {
        listIngredient.clear()
        listIngredient.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdvIngredientlist {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListIngredientBinding.inflate(layoutInflater, parent, false)
        return CdvIngredientlist(binding)
    }

    override fun getItemCount(): Int {
        if (listIngredient.size > limit) {
            return limit
        }else{
            return listIngredient.size
        }
    }

    override fun onBindViewHolder(holder: CdvIngredientlist, position: Int) {
        val data = listIngredient[position]
        holder.bind(data)
    }
}

class CdvIngredientlist(private val binding: ListIngredientBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: IngredientsItem) {
        with(binding) {
            txtIngredients.text = item.strIngredient
            txtDescription.text = item.strDescription
        }
    }

}
