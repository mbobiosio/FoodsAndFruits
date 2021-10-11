package com.mbobiosio.foodsandfruits.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbobiosio.foodsandfruits.databinding.ItemFoodsBinding
import com.mbobiosio.foodsandfruits.listener.FoodClickListener
import com.mbobiosio.foodsandfruits.model.Fruits

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class FoodsAdapter(
    private val listener: FoodClickListener
) : ListAdapter<Fruits, FoodsAdapter.FoodViewHolder>(ItemCallback()) {

    private class ItemCallback : DiffUtil.ItemCallback<Fruits>() {
        override fun areItemsTheSame(oldItem: Fruits, newItem: Fruits) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Fruits, newItem: Fruits) = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, listener)
        }
    }

    class FoodViewHolder(
        private val binding: ItemFoodsBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            fruits: Fruits,
            listener: FoodClickListener
        ) {
            binding.food = fruits
            binding.clickListener = listener
            binding.executePendingBindings()
        }
    }
}