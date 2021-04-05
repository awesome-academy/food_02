package com.example.gfood.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meal(
    val id: String?,
    val title: String?,
    val image: String?,
) : Parcelable

object MealEntry {
    const val ID = "idMeal"
    const val TITLE = "strMeal"
    const val IMAGE = "strMealThumb"
    const val MEAL = "meals"
}
