package com.hubinsord.caloriesapp.app.ui.foodlisting

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
        viewModel.products.observe(viewLifecycleOwner) {
            foodListingAdapter.submitList(it)
        }
    }

    private fun initFoodListingRecyclerView() {
        binding.rcvFoodListingProducts.apply {
            adapter = foodListingAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
//            layoutManager = GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)

//            layoutManager = FlexboxLayoutManager(requireContext()).apply {
//                flexWrap = FlexWrap.WRAP
//                flexDirection = FlexDirection.ROW
//                alignContent = AlignContent.STRETCH
//                alignItems = AlignItems.STRETCH
//                justifyContent = JustifyContent.CENTER
//
//            }
        }
    }

    private fun initSearchTV() {
        binding.etSearchProduct.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.onSearchProductTextChanged(p0)
            }
        })
    }

    private fun calculateNoOfColumns(columnWidthDp: Float): Int { // For example columnWidthdp=180
        val displayMetrics: DisplayMetrics = requireContext().resources.displayMetrics
        val screenWidthDp = displayMetrics.widthPixels / displayMetrics.density
        return (screenWidthDp / columnWidthDp + 0.5).toInt()
    }

}