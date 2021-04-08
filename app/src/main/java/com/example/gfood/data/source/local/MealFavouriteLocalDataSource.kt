package com.example.gfood.data.source.local

import android.content.Context
import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.MealFavouriteDataSource
import com.example.gfood.data.source.local.database.DatabaseHelper
import com.example.gfood.data.source.local.database.dao.MealFavouriteDaoImpl

class MealFavouriteLocalDataSource private constructor(
    private val mealFavouriteDaoImpl: MealFavouriteDaoImpl
) : MealFavouriteDataSource.Local {

    override fun save(meal: Meal?, listener: OnFetchDataLocalListener<Long>) {
        mealFavouriteDaoImpl.save(meal, listener)
    }

    override fun getListMealFavourite(listener: OnFetchDataLocalListener<MutableList<Meal>>) {
        mealFavouriteDaoImpl.getListMealFavourite(listener)
    }

    override fun delete(idMeal: String?, listener: OnFetchDataLocalListener<Int>) {
        mealFavouriteDaoImpl.delete(idMeal, listener)
    }

    override fun getMeal(idMeal: String?, listener: OnFetchDataLocalListener<Boolean>) {
        mealFavouriteDaoImpl.getMeal(idMeal, listener)
    }

    companion object {
        private var instance: MealFavouriteLocalDataSource? = null

        fun getInstance(context: Context): MealFavouriteDataSource.Local =
            instance ?: MealFavouriteLocalDataSource(
                MealFavouriteDaoImpl.getInstance(
                    DatabaseHelper.getInstance(context)
                )
            ).also {
                instance = it
            }
    }
}
