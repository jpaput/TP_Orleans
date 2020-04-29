package com.supinfo.tporleans.core.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.supinfo.tporleans.core.model.Cocktail

@Dao
interface CocktailDAO {

    @Query("SELECT * FROM cocktails")
    fun getAll() : List<Cocktail>

    @Insert
    suspend fun addCocktail(cocktail : Cocktail)

    @Insert
    suspend fun addCocktails(cocktail : List<Cocktail>)

    @Query("DELETE FROM cocktails")
    suspend fun deleteAll()
}