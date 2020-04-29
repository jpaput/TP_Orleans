package com.supinfo.tporleans.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.supinfo.tporleans.R
import com.supinfo.tporleans.core.model.Cocktail
import com.supinfo.tporleans.core.viewmodels.CocktailViewModel
import com.supinfo.tporleans.details.DetailCocktailActivity
import com.supinfo.tporleans.home.HomeActivity
import com.supinfo.tporleans.service.CocktailService
import kotlinx.android.synthetic.main.list_cocktail_activity.*

class ListCocktailsActivity : AppCompatActivity(), OnCocktailSeletedListener {


    companion object{
         val EXTRA_COCKTAIL_DATA = "EXTRA_COCKTAIL_DATA"
    }

    lateinit var viewModel : CocktailViewModel
    var search : String? = "a"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.list_cocktail_activity)

        viewModel = ViewModelProviders.of(this).get(CocktailViewModel::class.java)

        val extraString = intent?.getStringExtra(HomeActivity.EXTRA_STRING)

        if(extraString != null){
            search = extraString
        }

        viewModel.cocktailData.observe(this, Observer {
            recyclerView.adapter = CocktailsAdapter(it, this, this)
        })

        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()

        CocktailService(viewModel).getCocktail(search)
    }

    override fun onCocktailSelected(cocktail: Cocktail) {

        val intent = Intent(this, DetailCocktailActivity::class.java)
        intent.putExtra(EXTRA_COCKTAIL_DATA, cocktail)

        startActivity(intent)
    }
}