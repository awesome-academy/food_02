package com.example.gfood.data.source

import com.example.gfood.data.model.MealDetail
import com.example.gfood.data.source.remote.OnFetchDataJsonListener

interface MealDetailDataSource {

    interface Remote {
        fun getMealDatail(
            id: String?,
            listener: OnFetchDataJsonListener<MutableList<MealDetail>>
        )
    }
}
