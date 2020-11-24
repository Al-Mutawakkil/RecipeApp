package com.tugas.recipeapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tugas.recipeapp.R
import com.tugas.recipeapp.adapter.RvRecipeAdapter
import com.tugas.recipeapp.databinding.FragmentRecipeBinding
import com.tugas.recipeapp.model.ResponseMeals
import com.tugas.recipeapp.service.RetrofitBuilder
import kotlinx.android.synthetic.main.fragment_recipe.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RecipeFragment : Fragment() {

    private lateinit var binding: FragmentRecipeBinding
    private val resepAdapter = RvRecipeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.plant(Timber.DebugTree())
        binding = FragmentRecipeBinding.inflate(layoutInflater)
        with(binding) {
            binding.root
            rvListResep.adapter = resepAdapter
            rvListResep.layoutManager = LinearLayoutManager(context)
            rvListResep.setHasFixedSize(true)
        }
        val call = RetrofitBuilder.getService().fetchList()
        call.enqueue(object : Callback<ResponseMeals> {
            override fun onFailure(call: Call<ResponseMeals>, t: Throwable) {
                Timber.e(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseMeals>, response: Response<ResponseMeals>) {
                Timber.d(response.body()?.meals.toString())
                val listMealsItem = response.body()?.meals
                listMealsItem.let {
                    it?.let { it1 -> resepAdapter.addData(it1) }
                }
            }
        })

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvListResep.layoutManager = linearLayoutManager
        rvListResep.adapter = resepAdapter
    }

}