package com.example.gfood.screen.mealdetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gfood.R
import com.example.gfood.data.model.Meal

class MealDetailActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_detail)
    }

    companion object {
        private const val BUNDLE_MEAL = "BUNDLE_MEAL"

        fun newIntent(context: Context?, meal: Meal) =
            Intent(context, MealDetailActivity::class.java).apply {
                Bundle().apply {
                    putParcelable(BUNDLE_MEAL, meal)
                }
            }
    }
}
