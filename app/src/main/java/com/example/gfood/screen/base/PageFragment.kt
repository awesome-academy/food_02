package com.example.gfood.screen.base

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import com.example.gfood.utils.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.gfood.R
import com.example.gfood.screen.category.CategoryFragment
import com.example.gfood.screen.favourite.FavouriteFragment
import com.example.gfood.screen.search.SearchFragment
import com.example.gfood.utils.Constant
import kotlinx.android.synthetic.main.fragment_page.*

class PageFragment private constructor(): Fragment() {

    private val fragments = mutableListOf<Fragment>()
    private val categoryFragment = CategoryFragment.getInstance()
    private val searchFragment = SearchFragment.getInstance()
    private val favouriteFragment = FavouriteFragment.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFragment()
        fragmentManager?.let {
            viewPagerLayout.adapter = ViewPagerContainerAdapter(it, fragments)
            viewPagerLayout.offscreenPageLimit = Constant.LIMIT_OFFSET
            initBottomItem()
        }
    }

    private fun initFragment() {
        fragments.apply {
            add(MenuItem.CATEGORY.ordinal, categoryFragment)
            add(MenuItem.SEARCH.ordinal, searchFragment)
            add(MenuItem.FAVOURITE.ordinal, favouriteFragment)
        }
    }

    private fun initBottomItem() {
        bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.homeItem -> {
                    viewPagerLayout.currentItem = MenuItem.CATEGORY.ordinal
                    Log.e("selected ", MenuItem.CATEGORY.ordinal.toString())
                    true
                }
                R.id.searchItem -> {
                    viewPagerLayout.currentItem = MenuItem.SEARCH.ordinal
                    Log.e("selected ",  MenuItem.SEARCH.ordinal.toString())
                    true
                }
                R.id.favouriteItem -> {
                    viewPagerLayout.currentItem = MenuItem.FAVOURITE.ordinal
                    true
                }
                else -> false
            }
        }
        viewPagerLayout.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }

            override fun onPageScrollStateChanged(position: Int) {
            }

        })
    }

    companion object {

        private var instance: PageFragment? = null

        fun getInstance(): PageFragment {
            return instance ?: PageFragment().also {
                instance = it
            }
        }
    }
}
