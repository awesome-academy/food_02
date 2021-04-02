package com.example.gfood.screen.listmeal

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.data.source.repository.ListMealRepository
import com.example.gfood.screen.listmeals.ListMealConstract
import java.lang.Exception

class ListMealPresenter(
    private val repository: ListMealRepository
) : ListMealConstract.Presenter {

    private var view: ListMealConstract.View? = null

    override fun getListMeal(category: String) {
        repository.getListMeals(
            category = category,
            object : OnFetchDataJsonListener<MutableList<Meal>> {
                override fun onSuccess(data: MutableList<Meal>) {
                    view?.onGetListMealSuccess(data)
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            }
        )
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: ListMealConstract.View?) {
        this.view = view
    }
}
