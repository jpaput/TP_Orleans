package com.supinfo.tporleans.core

import com.supinfo.tporleans.core.model.CocktailWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndPoint {

    @GET("search.php")
    suspend fun getCocktail(@Query("f") car : String?) : Response<CocktailWrapper>
}