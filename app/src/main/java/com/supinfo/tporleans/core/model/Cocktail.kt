package com.supinfo.tporleans.core.model


import com.squareup.moshi.Json
import java.io.Serializable

//data class Cocktail(val name : String, val  drawable : Int) : Serializable {

data class Cocktail (
    val cocktailId : Int,
    val strDrink : String,
    val strDrinkThumb : String,
    val strIngredient1 : String?,
    val strIngredient2 : String?,
    val strIngredient3 : String?
): Serializable


