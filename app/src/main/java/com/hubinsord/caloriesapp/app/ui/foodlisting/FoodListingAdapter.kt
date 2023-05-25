package com.hubinsord.caloriesapp.app.ui.foodlisting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hubinsord.caloriesapp.R
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.databinding.ItemFoodListingBinding

class FoodListingAdapter(private val listener: FoodListingAdapterListener) :
    ListAdapter<Product, FoodListingAdapter.ViewHolder>(ProductComparator()) {

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

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val barcode = getItem(position).id
                    listener.onProductItemClicked(barcode)
                }
            }
        }

        fun bind(product: Product) {
            binding.apply {
                Glide.with(root)
                    .load(product.imageUrl)
                    .placeholder(R.drawable.ic_placeholder_item_food_listing)
                    .into(binding.ivProduct)
                tvProductNamePl.text = product.productName
            }
        }
    }

    companion object {
        interface FoodListingAdapterListener {
            fun onProductItemClicked(barcode: String)
        }
    }
}