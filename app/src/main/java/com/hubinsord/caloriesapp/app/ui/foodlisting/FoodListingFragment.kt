package com.hubinsord.caloriesapp.app.ui.foodlisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.hubinsord.caloriesapp.R
import com.hubinsord.caloriesapp.core.domain.entities.Resource
import com.hubinsord.caloriesapp.databinding.FragmentFoodListingBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FoodListingFragment : Fragment(R.layout.fragment_food_listing), FoodListingAdapter.Companion.FoodListingAdapterListener {

    private val viewModel: FoodListingViewModel by viewModels()
    private var _binding: FragmentFoodListingBinding? = null
    private val binding get() = _binding!!
    private val foodListingAdapter = FoodListingAdapter(this)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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
        initListeners()
    }

    private fun initFoodListingRecyclerView() {
        binding.rcvFoodListingProducts.apply {
            adapter = foodListingAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun initListeners() {
        binding.ivSearch.setOnClickListener {
            viewModel.onIvSearchClicked(binding.etSearchProduct.text.toString()  )
        }
    }

    private fun initObservers() {
        viewModel.products.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                    binding.fetchingProgressBar.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    hideProgressBar()
                    foodListingAdapter.submitList(it.data)
                }
                is Resource.Error -> {
                    hideProgressBar()
                    Toast.makeText(requireContext(), "ERROR ${it.error}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun hideProgressBar() {
        binding.fetchingProgressBar.visibility = View.INVISIBLE
    }

    override fun onProductItemClicked(barcode: String) {
        val action: NavDirections = FoodListingFragmentDirections.actionFoodListingFragmentToProductGeneralInfoFragment(barcode)
        findNavController().navigate(action)
    }

}