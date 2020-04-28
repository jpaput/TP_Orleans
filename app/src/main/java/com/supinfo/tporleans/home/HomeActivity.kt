package com.supinfo.tporleans.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.supinfo.tporleans.R
import com.supinfo.tporleans.list.ListCocktailsActivity
import kotlinx.android.synthetic.main.home_activity.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        discoverButton.setOnClickListener{
            startActivity(Intent(this, ListCocktailsActivity::class.java))
        }
    }
}
