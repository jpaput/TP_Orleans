package com.supinfo.tporleans.details

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.supinfo.tporleans.R
import com.supinfo.tporleans.core.model.Cocktail
import com.supinfo.tporleans.list.ListCocktailsActivity.Companion.EXTRA_COCKTAIL_DATA
import kotlinx.android.synthetic.main.detail_cocktail_activity.*

class DetailCocktailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_cocktail_activity)

        val cocktail : Cocktail = intent?.getSerializableExtra(EXTRA_COCKTAIL_DATA) as Cocktail

        cocktailName.text = cocktail.name
        cocktailImageView.setImageDrawable(getDrawable(cocktail.drawable))
    }
}