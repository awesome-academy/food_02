package com.example.gfood.data.source

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.remote.OnFetchDataJsonListener

interface ListMealDataSource {

    interface Remote {
        fun getListMeals(
            category: String,
            listener: OnFetchDataJsonListener<MutableList<Meal>>
        )
    }
}
