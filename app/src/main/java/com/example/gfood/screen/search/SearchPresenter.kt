package com.example.gfood.screen.search

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.data.source.repository.SearchRepository
import com.example.gfood.utils.KeyEntity

class SearchPresenter(private val repository: SearchRepository) : SearchContract.Presenter {

    private var view: SearchContract.View? = null

    override fun getMealFromFilter(keyEntity: KeyEntity?, query: String?) {
        repository.getMealFromFilter(keyEntity, query,
            object : OnFetchDataJsonListener<MutableList<Meal>> {
                override fun onSuccess(data: MutableList<Meal>) {
                    view?.onGetMealFromFilter(data)
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            }
        )
    }

    override fun onStart() {}

    override fun onStop() {}

    override fun setView(view: SearchContract.View?) {
        this.view = view
    }
}
