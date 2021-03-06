package com.example.gfood.screen.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gfood.R
import com.example.gfood.data.model.Category
import com.example.gfood.data.source.remote.CategoryRemoteDataSource
import com.example.gfood.data.source.repository.CategoryRepository
import com.example.gfood.screen.category.adapter.CategoryAdapter
import com.example.gfood.screen.listmeal.ListMealFragment
import com.example.gfood.utils.addFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : CategoryContract.View, Fragment() {

    private val categoryAdapter by lazy {
        CategoryAdapter() {
            addFragment(
                ListMealFragment.newInstance(it),
                R.id.containerLayout
            )
        }
    }
    private val categoryPresenter: CategoryContract.Presenter by lazy {
        CategoryPresenter(
            CategoryRepository.getInstance(
                CategoryRemoteDataSource.getInstances()
            )
        )
    }
    private val gridLayoutManager = GridLayoutManager(context, 2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
    }

    override fun onGetCategorySuccess(categories: MutableList<Category>) {
        categoryAdapter.updateData(categories)
    }

    override fun onError(exception: Exception?) {}

    private fun initData() {
        categoryPresenter.apply {
            setView(this@CategoryFragment)
            onStart()
        }
    }

    private fun initView() {
        recyclerViewCategory.apply {
            adapter = categoryAdapter
            layoutManager = gridLayoutManager
            setHasFixedSize(false)
        }
    }

    companion object {
        fun newInstance() = CategoryFragment()
    }
}
