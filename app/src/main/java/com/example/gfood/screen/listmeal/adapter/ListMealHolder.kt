package com.example.gfood.screen.listmeal.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.gfood.data.model.Meal
import com.example.gfood.utils.loadImage
import kotlinx.android.synthetic.main.item_layout_listmeal.view.*

class ListMealHolder(
    itemView: View,
    private var itemListener: (Meal) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bindViewData(meal: Meal) {
        itemView.apply {
            textViewMeal.text = meal.title
            imageMeal.loadImage(
                meal.image.toString()
            )
            setOnClickListener {
                itemListener(meal)
            }
        }
    }
}
