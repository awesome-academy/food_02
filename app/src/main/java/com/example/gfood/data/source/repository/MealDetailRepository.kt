package com.example.gfood.data.source.repository

import com.example.gfood.data.model.MealDetail
import com.example.gfood.data.source.MealDetailDataSource
import com.example.gfood.data.source.remote.OnFetchDataJsonListener

class MealDetailRepository(
    private val remote: MealDetailDataSource.Remote
) {

    fun getMealDetail(
        id: String?,
        listener: OnFetchDataJsonListener<MutableList<MealDetail>>
    ) {
        remote.getMealDatail(id, listener)
    }

    companion object {
        private var instance: MealDetailRepository? = null

        fun getInstance(
            remote: MealDetailDataSource.Remote
        ): MealDetailRepository {
            return instance ?: MealDetailRepository(remote).also {
                instance = it
            }
        }
    }
}
