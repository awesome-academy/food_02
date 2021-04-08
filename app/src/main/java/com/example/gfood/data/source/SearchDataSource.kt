package com.example.gfood.data.source

import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.remote.OnFetchDataJsonListener
import com.example.gfood.utils.KeyEntity

interface SearchDataSource {

    interface Remote{

        fun getMealFromFilter(
            keyEntity: KeyEntity?,
            query: String?,
            listener: OnFetchDataJsonListener<MutableList<Meal>>
        )
    }
}
