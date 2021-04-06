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
        entity: Meal,
        listener: OnFetchDataLocalListener<Long>
    ) {
        var isSuccess: Long?
        val contentValue = ContentValues().apply {
            put(MealFavouriteTable.COLUMN_ID_MEAL, entity.id)
            put(MealFavouriteTable.COLUMN_IMAGE, entity.image)
            put(MealFavouriteTable.COLUMN_NAME, entity.title)
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
        idEntity: String?,
        listener: OnFetchDataLocalListener<Int>
    ) {
        databaseHelper.writableDatabase.delete(
            MealFavouriteTable.TABLE_NAME,
            "${MealFavouriteTable.COLUMN_ID_MEAL}=?",
            arrayOf(idEntity)
        ).also {
            if (it > 0) listener.onSuccess(it)
            else listener.onFailed(R.string.failed_to_delete)
        }
    }

    override fun getMeal(
        idEntity: String?,
        listener: OnFetchDataLocalListener<Boolean>
    ) {
        val cursor = databaseHelper.readableDatabase.query(
            MealFavouriteTable.TABLE_NAME,
            null,
            "${MealFavouriteTable.COLUMN_ID_MEAL}=?",
            arrayOf(idEntity),
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
