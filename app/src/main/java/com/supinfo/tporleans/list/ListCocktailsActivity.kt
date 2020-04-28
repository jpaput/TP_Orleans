package com.supinfo.tporleans.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.supinfo.tporleans.R
import com.supinfo.tporleans.core.model.Cocktail
import com.supinfo.tporleans.details.DetailCocktailActivity
import kotlinx.android.synthetic.main.list_cocktail_activity.*
import mobile.francoisgaucher.fr.coktails.helper.CocktailsHelper

class ListCocktailsActivity : AppCompatActivity(), OnCocktailSeletedListener {


    companion object{
         val EXTRA_COCKTAIL_DATA = "EXTRA_COCKTAIL_DATA"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.list_cocktail_activity)

        recyclerView.adapter = CocktailsAdapter(CocktailsHelper.cocktails, this, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onCocktailSelected(cocktail: Cocktail) {

        val intent = Intent(this, DetailCocktailActivity::class.java)
        intent.putExtra(EXTRA_COCKTAIL_DATA, cocktail)

        startActivity(intent)
    }
}