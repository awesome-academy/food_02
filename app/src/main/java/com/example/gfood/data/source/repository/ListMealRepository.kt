package com.example.gfood.data.source.repository

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.ListMealDataSource
import com.example.gfood.data.source.remote.OnFetchDataJsonListener

class ListMealRepository private constructor(
    private val remote: ListMealDataSource.Remote
) {

    fun getListMeals(
        category: String,
        listener: OnFetchDataJsonListener<MutableList<Meal>>
    ) {
        remote.getListMeals(category, listener = listener)
    }

    companion object {

        private var instance: ListMealRepository? = null

        fun getInstance(remote: ListMealDataSource.Remote): ListMealRepository =
            instance ?: ListMealRepository(remote).also {
                instance = it
            }
    }
}
