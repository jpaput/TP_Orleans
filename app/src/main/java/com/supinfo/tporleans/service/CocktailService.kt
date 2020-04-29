package com.supinfo.tporleans.service

import android.app.Application
import androidx.annotation.WorkerThread
import com.supinfo.tporleans.core.ApiEndPoint
import com.supinfo.tporleans.core.helper.DataBaseHelper
import com.supinfo.tporleans.core.helper.NetworkUtil
import com.supinfo.tporleans.core.model.CocktailWrapper
import com.supinfo.tporleans.core.viewmodels.CocktailViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CocktailService(val viewModel : CocktailViewModel, val app : Application) {

    val cocktailDAO = DataBaseHelper.getDatabase(app).cocktailDao()
    val retroFitEndpoint : ApiEndPoint

    init {
        retroFitEndpoint = NetworkUtil.getRetrofit().create(ApiEndPoint::class.java)
    }

    fun getCocktail(search : String?){

        CoroutineScope(Dispatchers.IO).launch {
            if (NetworkUtil.isNetworkAvailable(app)) {

                cocktailDAO.deleteAll()
                cocktailDAO.addCocktails(
                    (retroFitEndpoint.getCocktail(search).body()
                        ?: CocktailWrapper(emptyList())).cocktails
                )

            }

            viewModel.setData(cocktailDAO.getAll())
        }
    }
}