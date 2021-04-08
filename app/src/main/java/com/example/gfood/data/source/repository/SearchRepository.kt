package com.example.gfood.data.source.repository

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.SearchDataSource
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.utils.KeyEntity

class SearchRepository private constructor(
    private val remote: SearchDataSource.Remote
) {

    fun getMealFromFilter(
        keyEntity: KeyEntity?,
        query: String?,
        listener: OnFetchDataJsonListener<MutableList<Meal>>
    ) {
        remote.getMealFromFilter(keyEntity, query, listener)
    }

    companion object {
        private var instance: SearchRepository? = null

        fun getInstance(remote: SearchDataSource.Remote) =
            instance ?: SearchRepository(remote).also {
                instance = it
            }
    }
}
