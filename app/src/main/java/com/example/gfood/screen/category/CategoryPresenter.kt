package com.example.gfood.screen.category

import com.example.gfood.data.model.Category
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.data.source.repository.CategoryRepository
import java.lang.Exception

class CategoryPresenter(private val repository: CategoryRepository) : ContractCategory.Presenter {

    private var view: ContractCategory.View? = null

    override fun getCategory() {
        repository.getCategory(object : OnFetchDataJsonListener<MutableList<Category>> {
            override fun onSuccess(data: MutableList<Category>) {
                view?.onGetCategorySuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.onError(exception)
            }
        })
    }

    override fun onStart() {
        getCategory()
    }

    override fun onStop() = Unit

    override fun setView(view: ContractCategory.View?) {
        this.view = view
    }
}
