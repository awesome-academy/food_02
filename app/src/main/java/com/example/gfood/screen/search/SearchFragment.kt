package com.example.gfood.screen.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gfood.R

class SearchFragment private constructor(): Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    companion object {

        private var instance: SearchFragment? = null

        fun getInstance(): SearchFragment {
            return instance ?: SearchFragment().also {
                instance = it
            }
        }
    }
}
