package com.example.gfood.data.source.remote.fetchjson

import com.example.gfood.data.model.*
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

    fun parseJsonToMealDetail(jsonObject: JSONObject?): MealDetail {
        return jsonObject.run {
            MealDetail(
                id = jsonObject?.getString(MealDetailEntry.ID),
                title = jsonObject?.getString(MealDetailEntry.TITLE),
                ingredient_one = jsonObject?.getString(MealDetailEntry.INGREDIENT_ONE),
                ingredient_two = jsonObject?.getString(MealDetailEntry.INGREDIENT_TWO),
                ingredient_three = jsonObject?.getString(MealDetailEntry.INGREDIENT_THREE),
                ingredient_four = jsonObject?.getString(MealDetailEntry.INGREDIENT_FOUR),
                ingredient_five = jsonObject?.getString(MealDetailEntry.INGREDIENT_FIVE),
                ingredient_six = jsonObject?.getString(MealDetailEntry.INGREDIENT_SIX),
                ingredient_seven = jsonObject?.getString(MealDetailEntry.INGREDIENT_SEVEN),
                ingredient_eight = jsonObject?.getString(MealDetailEntry.INGREDIENT_EIGHT),
                ingredient_nine = jsonObject?.getString(MealDetailEntry.INGREDIENT_NINE),
                ingredient_ten = jsonObject?.getString(MealDetailEntry.INGREDIENT_TEN),
                linkVideo = jsonObject?.getString(MealDetailEntry.LINK_VIDEO),
                instructions = jsonObject?.getString(MealDetailEntry.INSTRUCTION)
            )
        }
    }
}
