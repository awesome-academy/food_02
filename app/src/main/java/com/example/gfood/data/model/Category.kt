package com.example.gfood.data.model

data class Category(
    val id: String?,
    val name: String?,
    val image: String?,
    val description: String?
)

object CategoryEntry {
    const val CATEGORY = "categories"
    const val ID = "idCategory"
    const val NAME = "strCategory"
    const val IMAGE = "strCategoryThumb"
    const val DESCRIPTION = "strCategoryDescription"
}
