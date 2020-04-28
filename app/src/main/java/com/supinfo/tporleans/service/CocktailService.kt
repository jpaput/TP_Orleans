package com.supinfo.tporleans.service

import com.supinfo.tporleans.core.model.CocktailWrapper
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {

    @GET("search.php")
    suspend fun getCocktail(@Query("f") car : String) : Response<CocktailWrapper>
}