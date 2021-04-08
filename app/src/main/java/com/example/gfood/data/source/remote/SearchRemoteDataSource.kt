package com.example.gfood.data.source.remote

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.SearchDataSource
import com.example.gfood.data.source.remote.fetchjson.GetJsonFromUrl
import com.example.gfood.utils.Constant
import com.example.gfood.utils.KeyEntity

class SearchRemoteDataSource private constructor() : SearchDataSource.Remote {

    override fun getMealFromFilter(
        keyEntity: KeyEntity?,
        query: String?,
        listener: OnFetchDataJsonListener<MutableList<Meal>>
    ) {
        var baseUrl = Constant.BASE_URL
        when (keyEntity) {
            KeyEntity.FILTER_CATEGORY -> baseUrl += Constant.BASE_LIST_MEAL + query
            KeyEntity.FILTER_NAME -> baseUrl += Constant.BASE_URL_FILTER_BY_NAME + query
            KeyEntity.FILTER_INGREDIENT -> {
                val queryText = query?.trim()?.replace(" ", "_")?.toLowerCase()
                baseUrl += Constant.BASE_URL_FILTER_BY_INGREDIENT + queryText
            }
            else -> null
        }
        GetJsonFromUrl(KeyEntity.FILTER, listener).execute(baseUrl)
    }

    companion object {
        private var instance: SearchRemoteDataSource? = null

        fun getInstance(): SearchDataSource.Remote =
            instance ?: SearchRemoteDataSource().also {
                instance = it
            }
    }
}
