package com.supinfo.tporleans.service

import androidx.annotation.WorkerThread
import com.supinfo.tporleans.core.ApiEndPoint
import com.supinfo.tporleans.core.helper.NetworkUtil
import com.supinfo.tporleans.core.model.CocktailWrapper
import com.supinfo.tporleans.core.viewmodels.CocktailViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CocktailService(val viewModel : CocktailViewModel) {

    fun getCocktail(search : String?){
            CoroutineScope(Dispatchers.IO).launch {
                val retroFitEndpoint = NetworkUtil.getRetrofit().create(ApiEndPoint::class.java)

                viewModel.setData(
                    retroFitEndpoint.getCocktail(search).body() ?: CocktailWrapper(emptyList()))

            }
    }
}