package com.example.gfood.data.source.remote

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.ListMealDataSource
import com.example.gfood.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.gfood.utils.Constant
import com.example.gfood.utils.KeyEntity

class ListMealRemoteDataSource private constructor() : ListMealDataSource.Remote {

    override fun getListMeals(
        category: String,
        listener: OnFetchDataJsonListener<MutableList<Meal>>
    ) {
        var baseUrl = Constant.BASE_URL +
                Constant.BASE_LIST_MEAL +
                category
        GetJsonFromUrl(
            keyEntity = KeyEntity.LIST_MEALS,
            listener = listener
        ).execute(baseUrl)
    }

    companion object {
        private var instance: ListMealRemoteDataSource? = null

        fun getInstance(): ListMealDataSource.Remote {
            return instance ?: ListMealRemoteDataSource().also {
                instance = it
            }
        }
    }
}
