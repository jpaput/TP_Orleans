package com.supinfo.tporleans.core.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.supinfo.tporleans.core.model.Cocktail
import com.supinfo.tporleans.core.model.CocktailWrapper

class CocktailViewModel (app : Application) : AndroidViewModel(app) {

    var cocktailData = MutableLiveData<List<Cocktail>>()

    public fun setData(cocktailWrapper : CocktailWrapper){
        cocktailData.postValue(cocktailWrapper.cocktails)
    }

}