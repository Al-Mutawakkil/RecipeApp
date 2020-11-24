package com.tugas.recipeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tugas.recipeapp.fragment.IngredientFragment
import com.tugas.recipeapp.fragment.RecipeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomnav.setOnNavigationItemSelectedListener(onBotNavListener)

        val frag = supportFragmentManager.beginTransaction()
        frag.add(R.id.frag_container, RecipeFragment())
        frag.commit()
    }

    private val onBotNavListener = BottomNavigationView.OnNavigationItemSelectedListener {i->
        var selectedFragment: Fragment = RecipeFragment()

        when(i.itemId) {
            R.id.recipe -> {
                selectedFragment = RecipeFragment()
            }
            R.id.ingredient -> {
                selectedFragment = IngredientFragment()
            }
        }
        val frag = supportFragmentManager.beginTransaction()
        frag.replace(R.id.frag_container, selectedFragment)
        frag.commit()

        true
    }
}