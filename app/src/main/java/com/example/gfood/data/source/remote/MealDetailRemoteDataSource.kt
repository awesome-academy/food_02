package com.example.gfood.data.source.remote

import com.example.gfood.data.model.MealDetail
import com.example.gfood.data.source.MealDetailDataSource
import com.example.gfood.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.gfood.utils.Constant
import com.example.gfood.utils.KeyEntity

class MealDetailRemoteDataSource private constructor() : MealDetailDataSource.Remote {

    override fun getMealDatail(
        id: String?,
        listener: OnFetchDataJsonListener<MutableList<MealDetail>>
    ) {
        var baseUrl = Constant.BASE_URL +
                Constant.BASE_MEAL +
                id
        GetJsonFromUrl(
            KeyEntity.MEAL,
            listener
        ).execute(baseUrl)
    }

    companion object {

        private var instance: MealDetailRemoteDataSource? = null

        fun getInstance(): MealDetailDataSource.Remote {
            return instance ?: MealDetailRemoteDataSource().also {
                instance = it
            }
        }
    }
}
