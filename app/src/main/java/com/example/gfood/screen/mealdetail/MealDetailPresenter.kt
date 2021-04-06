package com.example.gfood.screen.mealdetail

import com.example.gfood.data.model.Meal
import com.example.gfood.data.model.MealDetail
import com.example.gfood.data.source.local.OnFetchDataLocalListener
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.data.source.repository.MealDetailRepository
import com.example.gfood.data.source.repository.MealFavouriteRepository

class MealDetailPresenter(
    private val repository: MealDetailRepository,
    private val repositoryLocal: MealFavouriteRepository
) : ContractMealDetail.Presenter {

    private var view: ContractMealDetail.View? = null

    override fun getListMealDetails(id: String?) {
        repository.getMealDetail(id, object : OnFetchDataJsonListener<MutableList<MealDetail>> {
            override fun onSuccess(data: MutableList<MealDetail>) {
                view?.onGetMealDetailSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun getMealFavourite() {
        repositoryLocal.getListMealFavourite(object :
            OnFetchDataLocalListener<MutableList<Meal>> {
            override fun onSuccess(data: MutableList<Meal>) {
                view?.onGetMealFavouriteSuccess(data)
            }

            override fun onFailed(idMessage: Int) {
                view?.onFailed(idMessage)
            }
        })
    }

    override fun onSaveMealFavourite(meal: Meal) {
        repositoryLocal.save(meal, object : OnFetchDataLocalListener<Long> {
            override fun onSuccess(data: Long) {
                view?.onSaveMealFavourite()
            }

            override fun onFailed(idMessage: Int) {
                view?.onFailed(idMessage)
            }
        })
    }

    override fun onDeleteMealFavourite(idMeal: String?) {
        repositoryLocal.delete(idMeal, object : OnFetchDataLocalListener<Int> {
            override fun onSuccess(data: Int) {
                view?.onDeleteMealFavourite()
            }

            override fun onFailed(idMessage: Int) {
                view?.onFailed(idMessage)
            }
        })
    }

    override fun onGetMeal(idEntity: String?) {
        repositoryLocal.getMeal(
            idEntity,
            object : OnFetchDataLocalListener<Boolean> {
                override fun onSuccess(data: Boolean) {
                    view?.onGetMeal(data)
                }

                override fun onFailed(idMessage: Int) {}
            })
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: ContractMealDetail.View?) {
        this.view = view
    }
}
