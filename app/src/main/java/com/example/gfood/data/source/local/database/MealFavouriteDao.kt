package com.example.gfood.data.source.local.database

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.local.OnFetchDataLocalListener

interface MealFavouriteDao {

    fun save(
        entity: Meal,
        listener: OnFetchDataLocalListener<Long>
    )

    fun getListMealFavourite(
        listener: OnFetchDataLocalListener<MutableList<Meal>>
    )

    fun delete(
        idEntity: String?,
        listener: OnFetchDataLocalListener<Int>
    )

    fun getMeal(
        idEntity: String?,
        listener: OnFetchDataLocalListener<Boolean>
    )
}
