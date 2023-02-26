package com.hubinsord.caloriesapp.app.ui.foodlisting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hubinsord.caloriesapp.R
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.extensions.load
import com.hubinsord.caloriesapp.databinding.ItemFoodListingBinding

class FoodListingAdapter() : ListAdapter<Product, FoodListingAdapter.ViewHolder>(ProductComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFoodListingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class ProductComparator : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: ItemFoodListingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.apply {
                Glide.with(binding.root)
                    .load(product.imageUrl)
                    .placeholder(R.drawable.ic_placeholder_item_food_listing)
                    .into(binding.ivProduct)
//                ivProduct.load(product.imageUrl)
//                tvId.text = product.id.toString()
//                tvBrand.text = product.brand
                tvProductNamePl.text = product.productName
            }
        }

    }
}