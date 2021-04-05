package com.example.gfood.screen.listmeal.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gfood.R
import com.example.gfood.data.model.Meal

class ListMealAdapter() : RecyclerView.Adapter<ListMealHolder>() {

    private val listMeals = mutableListOf<Meal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMealHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_listmeal, parent, false)
        return ListMealHolder(view)
    }

    override fun onBindViewHolder(holder: ListMealHolder, position: Int) {
        holder.bindViewData(listMeals[position])
    }

    override fun getItemCount() = listMeals.size

    fun updateData(list: MutableList<Meal>) {
        list.let {
            listMeals.clear()
            listMeals.addAll(it)
            notifyDataSetChanged()
        }
    }
}
