package com.example.gfood.screen.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gfood.R
import com.example.gfood.data.model.Category
import com.example.gfood.data.source.repository.CategoryRepository
import com.example.gfood.screen.category.adapter.CategoryRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import java.lang.Exception

class CategoryFragment private constructor() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    companion object {

        private var instance: CategoryFragment? = null

        fun getInstance(): CategoryFragment {
            return instance ?: CategoryFragment().also {
                instance = it
            }
        }
    }
}
