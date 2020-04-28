package com.supinfo.tporleans.list

import android.content.Intent
import android.os.Bundle
import androidx.annotation.WorkerThread
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.supinfo.tporleans.core.model.Cocktail
import com.supinfo.tporleans.R
import com.supinfo.tporleans.core.helper.NetworkUtil
import com.supinfo.tporleans.core.model.CocktailWrapper
import com.supinfo.tporleans.details.DetailCocktailActivity
import com.supinfo.tporleans.service.CocktailService
import kotlinx.android.synthetic.main.list_cocktail_activity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListCocktailsActivity : AppCompatActivity(), OnCocktailSeletedListener {


    companion object{
         val EXTRA_COCKTAIL_DATA = "EXTRA_COCKTAIL_DATA"
    }

    lateinit var adapter : CocktailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.list_cocktail_activity)

        adapter = CocktailsAdapter(this, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()

        CoroutineScope(Dispatchers.IO).launch {
            getData()
        }
    }

    @WorkerThread
    suspend fun getData() {

        val cocktailService =  NetworkUtil.getRetrofit().create(CocktailService::class.java)
        val cocktailWrapper = cocktailService.getCocktail("a").body() ?: CocktailWrapper(emptyList())

        CoroutineScope(Dispatchers.Main).launch {
            adapter.setCocktails(cocktailWrapper.cocktails)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCocktailSelected(cocktail: Cocktail) {

        val intent = Intent(this, DetailCocktailActivity::class.java)
        intent.putExtra(EXTRA_COCKTAIL_DATA, cocktail)

        startActivity(intent)
    }
}