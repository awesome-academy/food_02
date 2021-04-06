package com.example.gfood.screen.mealdetail

import com.example.gfood.data.model.MealDetail
import com.example.gfood.utils.BasePresenter

interface ContractMealDetail {

    interface View {
        fun onGetMealDetailSuccess(listMealDetails: MutableList<MealDetail>)
        fun onError(exception: Exception)
    }

    interface Presenter : BasePresenter<View> {
        fun getListMealDetails(id: String?)
    }
}
