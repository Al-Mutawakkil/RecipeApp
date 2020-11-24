package com.tugas.recipeapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tugas.recipeapp.R
import com.tugas.recipeapp.adapter.RvIngredientAdapter
import com.tugas.recipeapp.databinding.FragmentIngredientBinding
import com.tugas.recipeapp.databinding.ListIngredientBinding
import com.tugas.recipeapp.model.ResponseIngredient
import com.tugas.recipeapp.service.RetrofitBuilder
import com.tugas.recipeapp.service.RetrofitBuilder2
import kotlinx.android.synthetic.main.fragment_ingredient.*
import kotlinx.android.synthetic.main.fragment_recipe.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class IngredientFragment : Fragment() {

    private lateinit var binding: FragmentIngredientBinding
    private val ingredientAdapter = RvIngredientAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ingredient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.plant(Timber.DebugTree())
        binding = FragmentIngredientBinding.inflate(layoutInflater)
        with(binding) {
            binding.root
            rvListIngred.adapter = ingredientAdapter
            rvListIngred.layoutManager = LinearLayoutManager(context)
            rvListIngred.setHasFixedSize(true)
        }
        val call = RetrofitBuilder2.getService().fetchList()
        call.enqueue(object : Callback<ResponseIngredient> {
            override fun onFailure(call: Call<ResponseIngredient>, t: Throwable) {
                Timber.e(t.localizedMessage)
            }

            override fun onResponse(call: Call<ResponseIngredient>, response: Response<ResponseIngredient>) {
                Timber.d(response.body()?.meals.toString())
                val listItem = response.body()?.meals
                listItem.let {
                    it?.let { it2 -> ingredientAdapter.addData(it2)}
                }
            }
        })

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        rvListIngred.layoutManager = linearLayoutManager
        rvListIngred.adapter = ingredientAdapter

    }


}