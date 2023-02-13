package com.hubinsord.caloriesapp.app.ui.foodlisting

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.hubinsord.caloriesapp.R
import com.hubinsord.caloriesapp.databinding.FragmentFoodListingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodListingFragment : Fragment(R.layout.fragment_food_listing) {

    private val viewModel: FoodListingViewModel by viewModels()
    private var _binding: FragmentFoodListingBinding? = null
    private val binding get() = _binding!!
    private val foodListingAdapter = FoodListingAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFoodListingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initViews()
        initObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initViews() {
        initFoodListingRecyclerView()
        initSearchTV()
    }

    private fun initObservers() {
        viewModel.products.observe(viewLifecycleOwner){
            foodListingAdapter.submitList(it)
        }
    }

    private fun initFoodListingRecyclerView() {
        binding.rcvFoodListingProducts.apply {
            adapter = foodListingAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initSearchTV() {
        binding.etSearchProduct.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onSearchProductTextChanged(p0)
            }
        })
    }

}