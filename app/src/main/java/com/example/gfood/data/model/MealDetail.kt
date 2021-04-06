package com.example.gfood.data.model

data class MealDetail(
    val id: String?,
    val title: String?,
    val instructions: String?,
    val linkVideo: String?,
    val ingredient_one: String?,
    val ingredient_two: String?,
    val ingredient_three: String?,
    val ingredient_four: String?,
    val ingredient_five: String?,
    val ingredient_six: String?,
    val ingredient_seven: String?,
    val ingredient_eight: String?,
    val ingredient_nine: String?,
    val ingredient_ten: String?,
)

object MealDetailEntry {
    const val ID = "idMeal"
    const val TITLE = "strMeal"
    const val INSTRUCTION = "strInstructions"
    const val LINK_VIDEO = "strYoutube"
    const val INGREDIENT_ONE = "strIngredient1"
    const val INGREDIENT_TWO = "strIngredient2"
    const val INGREDIENT_THREE = "strIngredient3"
    const val INGREDIENT_FOUR = "strIngredient4"
    const val INGREDIENT_FIVE = "strIngredient5"
    const val INGREDIENT_SIX = "strIngredient6"
    const val INGREDIENT_SEVEN = "strIngredient7"
    const val INGREDIENT_EIGHT = "strIngredient8"
    const val INGREDIENT_NINE = "strIngredient9"
    const val INGREDIENT_TEN = "strIngredient10"
    const val MEAL_DETAIL = "meals"
}
