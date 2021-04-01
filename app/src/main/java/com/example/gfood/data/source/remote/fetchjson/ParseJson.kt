package com.example.gfood.data.source.remote.fetchjson

import com.example.gfood.data.model.Category
import com.example.gfood.data.model.CategoryEntry
import com.example.gfood.data.model.Meal
import com.example.gfood.data.model.MealEntry
import org.json.JSONObject

class ParseJson {

    fun parseJsonToCategory(jsonObject: JSONObject?): Category =
        jsonObject.run {
            Category(
                id = jsonObject?.getString(CategoryEntry.ID),
                name = jsonObject?.getString(CategoryEntry.NAME),
                image = jsonObject?.getString(CategoryEntry.IMAGE),
                description = jsonObject?.getString(CategoryEntry.DESCRIPTION)
            )
        }

    fun parseJsonToMeal(jsonObject: JSONObject?): Meal =
        jsonObject.run {
            Meal(
                id = jsonObject?.getString(MealEntry.ID),
                title = jsonObject?.getString(MealEntry.TITLE),
                image = jsonObject?.getString(MealEntry.IMAGE)
            )
        }
}
