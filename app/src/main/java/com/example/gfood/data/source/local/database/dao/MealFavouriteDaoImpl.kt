package com.example.gfood.data.source.local.database.dao

import android.content.ContentValues
import com.example.gfood.R
import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.local.OnFetchDataLocalListener
import com.example.gfood.data.source.local.database.DatabaseHelper
import com.example.gfood.data.source.local.database.MealFavouriteDao
import com.example.gfood.data.source.local.database.table.MealFavouriteTable

class MealFavouriteDaoImpl private constructor(
    private val databaseHelper: DatabaseHelper
) : MealFavouriteDao {

    override fun save(
        meal: Meal?,
        listener: OnFetchDataLocalListener<Long>
    ) {
        var isSuccess: Long?
        val contentValue = ContentValues().apply {
            put(MealFavouriteTable.COLUMN_ID_MEAL, meal?.id)
            put(MealFavouriteTable.COLUMN_IMAGE, meal?.image)
            put(MealFavouriteTable.COLUMN_NAME, meal?.title)
        }
        databaseHelper.writableDatabase.insert(
            MealFavouriteTable.TABLE_NAME,
            null,
            contentValue
        ).also {
            isSuccess = it
        }
        isSuccess?.let {
            if (it > 0) listener.onSuccess(it)
            else listener.onFailed(R.string.failed_to_save)
        }
    }

    override fun getListMealFavourite(
        listener: OnFetchDataLocalListener<MutableList<Meal>>
    ) {
        val meals = mutableListOf<Meal>()
        val cursor = databaseHelper.readableDatabase.query(
            MealFavouriteTable.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
        )
        if (cursor != null) {
            with(cursor) {
                while (moveToNext()) {
                    meals.add(
                        Meal(
                            id = getString(getColumnIndex(MealFavouriteTable.COLUMN_ID_MEAL)),
                            title = getString(getColumnIndex(MealFavouriteTable.COLUMN_NAME)),
                            image = getString(getColumnIndex(MealFavouriteTable.COLUMN_IMAGE))
                        )
                    )
                }
            }
            listener.onSuccess(meals)
        } else listener.onFailed(R.string.failed_to_select)

    }

    override fun delete(
        idMeal: String?,
        listener: OnFetchDataLocalListener<Int>
    ) {
        databaseHelper.writableDatabase.delete(
            MealFavouriteTable.TABLE_NAME,
            "${MealFavouriteTable.COLUMN_ID_MEAL}=?",
            arrayOf(idMeal)
        ).also {
            if (it > 0) listener.onSuccess(it)
            else listener.onFailed(R.string.failed_to_delete)
        }
    }

    override fun getMeal(
        idMeal: String?,
        listener: OnFetchDataLocalListener<Boolean>
    ) {
        val cursor = databaseHelper.readableDatabase.query(
            MealFavouriteTable.TABLE_NAME,
            null,
            "${MealFavouriteTable.COLUMN_ID_MEAL}=?",
            arrayOf(idMeal),
            null,
            null,
            null,
            null,
        )
        if (cursor != null) {
            with(cursor) {
                while (moveToNext()) {
                    listener.onSuccess(true)
                }
            }
        } else listener.onSuccess(false)
    }

    companion object {
        private var instance: MealFavouriteDaoImpl? = null

        fun getInstance(databaseHelper: DatabaseHelper): MealFavouriteDaoImpl =
            instance ?: MealFavouriteDaoImpl(databaseHelper).also {
                instance = it
            }
    }
}
