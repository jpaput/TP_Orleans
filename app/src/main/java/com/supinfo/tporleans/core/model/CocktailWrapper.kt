package com.supinfo.tporleans.core.model

import com.squareup.moshi.Json
import java.io.Serializable

data class CocktailWrapper  (
    @field:Json(name = "drinks") val cocktails : List<Cocktail>
): Serializable
