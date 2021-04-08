package com.example.gfood.screen.mealdetail

import com.example.gfood.data.model.Meal
import com.example.gfood.data.model.MealDetail
import com.example.gfood.utils.BasePresenter
import java.lang.Exception

interface ContractMealDetail {

    interface View {
        fun onGetMealDetailSuccess(listMealDetails: MutableList<MealDetail>)
        fun onGetMealFavouriteSuccess(meals: MutableList<Meal>)
        fun onSaveMealFavourite()
        fun onDeleteMealFavourite()
        fun onFailed(idMessage: Int)
        fun onError(exception: Exception?)
        fun onGetMeal(boolean: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun getListMealDetails(id: String?)
        fun getMealFavourite()
        fun onSaveMealFavourite(meal: Meal?)
        fun onDeleteMealFavourite(idMeal: String?)
        fun onGetMeal(idMeal: String?)
    }
}
