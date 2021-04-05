package com.example.gfood.screen.listmeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gfood.R
import com.example.gfood.data.model.Category
import com.example.gfood.data.model.Meal
import com.example.gfood.data.source.remote.ListMealRemoteDataSource
import com.example.gfood.data.source.repository.ListMealRepository
import com.example.gfood.screen.listmeal.adapter.ListMealAdapter
import com.example.gfood.screen.listmeals.ListMealConstract
import com.example.gfood.screen.main.MainActivity
import com.example.gfood.utils.loadImage
import kotlinx.android.synthetic.main.fragment_list_meal.*

class ListMealFragment : Fragment(), ListMealConstract.View {

    private val listMealAdapter by lazy {
        ListMealAdapter()
    }
    private var presenter: ListMealPresenter? = null
    private var category: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getParcelable(ARGUMENT_CATEGORY) as? Category
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_meal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        initView()
        initData()
        onClickButton()
    }

    override fun onGetListMealSuccess(listMeals: MutableList<Meal>) {
        listMealAdapter.updateData(listMeals)
    }

    override fun onError(exception: Exception?) {}

    private fun initData() {
        presenter = ListMealPresenter(
            ListMealRepository.getInstance(
                ListMealRemoteDataSource.getInstance()
            )
        )
        presenter?.apply {
            setView(this@ListMealFragment)
            getListMeal(category?.name.toString())
        }
    }

    private fun initView() {
        recyclerViewListMeals.apply {
            adapter = listMealAdapter
            setHasFixedSize(false)
        }
    }

    private fun setData() {
        textCategory.text = category?.name
        textDesciption.text = category?.description
        imageCategory.loadImage(category?.image.toString())
    }

    private fun onClickButton() {
        btnClose.setOnClickListener {
            startActivity(MainActivity.newIntent(context))
        }
    }

    companion object {

        private const val ARGUMENT_CATEGORY = "ARGUMENT_CATEGORY"

        fun newInstance(category: Category) =
            ListMealFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARGUMENT_CATEGORY, category)
                }
            }
    }
}
