package com.example.gfood.screen.search

import com.example.gfood.data.model.Meal
import com.example.gfood.utils.BasePresenter
import com.example.gfood.utils.KeyEntity

interface SearchContract {

    interface View {
        fun onGetMealFromFilter(meals: MutableList<Meal>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getMealFromFilter(keyEntity: KeyEntity?, query: String?)
    }
}
