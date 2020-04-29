package com.supinfo.tporleans.core.helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.supinfo.tporleans.core.dao.CocktailDAO
import com.supinfo.tporleans.core.model.Cocktail
import java.security.AccessControlContext

@Database(entities = [Cocktail::class], version = 1, exportSchema = false)
abstract class DataBaseHelper : RoomDatabase(){

    abstract public fun cocktailDao(): CocktailDAO

    companion object{
        @Volatile
        private var INSTANCE : DataBaseHelper? = null

        fun getDatabase(context: Context) : DataBaseHelper{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DataBaseHelper::class.java,
                        "cocktail.db"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}