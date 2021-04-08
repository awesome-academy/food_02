package com.example.gfood.data.source.local.database

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.local.OnFetchDataLocalListener

interface MealFavouriteDao {

    fun save(meal: Meal?, listener: OnFetchDataLocalListener<Long>)

    fun getListMealFavourite(listener: OnFetchDataLocalListener<MutableList<Meal>>)

    fun delete(idMeal: String?, listener: OnFetchDataLocalListener<Int>)

    fun getMeal(idMeal: String?, listener: OnFetchDataLocalListener<Boolean>)
}
