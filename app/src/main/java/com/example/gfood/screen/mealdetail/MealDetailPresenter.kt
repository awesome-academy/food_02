package com.example.gfood.screen.mealdetail

import com.example.gfood.data.model.MealDetail
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.data.source.repository.MealDetailRepository

class MealDetailPresenter(private val repository: MealDetailRepository) :
    ContractMealDetail.Presenter {

    private var view: ContractMealDetail.View? = null

    override fun getListMealDetails(id: String?) {
        repository.getMealDetail(
            id,
            object : OnFetchDataJsonListener<MutableList<MealDetail>> {
                override fun onSuccess(data: MutableList<MealDetail>) {
                    view?.onGetMealDetailSuccess(data)
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception!!)
                }
            }
        )
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: ContractMealDetail.View?) {
        this.view = view
    }
}
