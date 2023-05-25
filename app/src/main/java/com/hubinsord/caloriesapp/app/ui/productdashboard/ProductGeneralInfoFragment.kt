package com.hubinsord.caloriesapp.app.ui.productdashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hubinsord.caloriesapp.R
import com.hubinsord.caloriesapp.databinding.FragmentProductGeneralInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductGeneralInfoFragment : Fragment(R.layout.fragment_product_general_info) {

    private val viewModel: ProductGeneralInfoViewModel by viewModels()
    private var _binding: FragmentProductGeneralInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentProductGeneralInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = ProductGeneralInfoFragment()
    }
}