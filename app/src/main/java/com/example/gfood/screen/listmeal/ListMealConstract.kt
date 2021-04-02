package com.example.gfood.screen.listmeals

import com.example.gfood.data.model.Meal
import com.example.gfood.utils.BasePresenter
import java.lang.Exception

interface ListMealConstract {

    interface View {
        fun onGetListMealSuccess(listMeals: MutableList<Meal>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getListMeal(category: String)
    }
}
