package com.supinfo.tporleans.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.supinfo.tporleans.R
import com.supinfo.tporleans.details.DetailCocktailActivity
import com.supinfo.tporleans.list.ListCocktailsActivity
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : AppCompatActivity() {

    companion object{
        val EXTRA_STRING = "EXTRA_STRING"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        searchButton.setOnClickListener{
            val intent = Intent(this, ListCocktailsActivity::class.java)
            intent.putExtra(HomeActivity.EXTRA_STRING, searchEditText.text.toString())

            startActivity(intent)
        }

        discoverButton.setOnClickListener{
            startActivity(Intent(this, ListCocktailsActivity::class.java))
        }
    }
}
