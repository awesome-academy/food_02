package com.example.gfood.data.source.repository

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.MealFavouriteDataSource
import com.example.gfood.data.source.local.OnFetchDataLocalListener

class MealFavouriteRepository(
    private val local: MealFavouriteDataSource.Local
) {
    fun save(
        meal: Meal?,
        listener: OnFetchDataLocalListener<Long>
    ) {
        local.save(meal, listener)
    }

    fun getListMealFavourite(
        listener: OnFetchDataLocalListener<MutableList<Meal>>
    ) {
        local.getListMealFavourite(listener)
    }

    fun delete(
        idMeal: String?,
        listener: OnFetchDataLocalListener<Int>
    ) {
        local.delete(idMeal, listener)
    }

    fun getMeal(
        idMeal: String?,
        listener: OnFetchDataLocalListener<Boolean>
    ) {
        local.getMeal(idMeal, listener)
    }

    companion object {
        private var instance: MealFavouriteRepository? = null

        fun getInstance(
            local: MealFavouriteDataSource.Local
        ): MealFavouriteRepository {
            return instance ?: MealFavouriteRepository(local).also {
                instance = it
            }
        }
    }
}
