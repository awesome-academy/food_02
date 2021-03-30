package com.example.gfood.screen.listmeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gfood.R
import com.example.gfood.data.model.Category

class ListMealFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_meal, container, false)
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
