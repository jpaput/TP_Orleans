package com.supinfo.tporleans.list

import com.supinfo.tporleans.core.model.Cocktail

interface OnCocktailSeletedListener {
        fun onCocktailSelected(cocktail : Cocktail)
}