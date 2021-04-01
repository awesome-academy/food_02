package com.example.gfood.data.model

data class Meal(
    val id: String?,
    val title: String?,
    val image: String?,
)

object MealEntry {
    const val ID = "idMeal"
    const val TITLE = "strMeal"
    const val IMAGE = "strMealThumb"
    const val MEAL = "meals"
}
