package com.example.gfood.data.source.repository

import com.example.gfood.data.model.Category
import com.example.gfood.data.source.CategoryDataSource
import com.example.gfood.data.source.remote.CategoryRemoteDataSource
import com.example.gfood.data.source.remote.OnFetchDataJsonListener

class CategoryRepository private constructor(private val remote: CategoryDataSource.Remote) {

    fun getCategory(listener: OnFetchDataJsonListener<MutableList<Category>>) {
        remote.getCategory(listener)
    }

    companion object {
        private var instance: CategoryRepository? = null

        fun getInstance(): CategoryRepository? {
            return instance ?: CategoryRepository(CategoryRemoteDataSource.getInstances()).also {
                instance = it
            }
        }
    }
}
