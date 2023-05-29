package com.hubinsord.caloriesapp.app.ui.productdashboard

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.hubinsord.caloriesapp.R
import com.hubinsord.caloriesapp.core.domain.entities.Resource
import com.hubinsord.caloriesapp.databinding.FragmentProductGeneralInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductGeneralInfoFragment : Fragment(R.layout.fragment_product_general_info) {

    private val viewModel: ProductGeneralInfoViewModel by viewModels()
    private var _binding: FragmentProductGeneralInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductGeneralInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        initViews()
        initObservers()
        viewModel.getProduct()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initObservers() {
        viewModel.product.observe(viewLifecycleOwner) { product ->
            when (product) {
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "LOADING... ", Toast.LENGTH_LONG).show()
                }
                is Resource.Success -> {
                    product.data.let {
                        binding.tvProductName.text = it?.productName
                    }
                }
                is Resource.Error -> {
                    product.error?.let { showErrorDialog(it) }
                    Toast.makeText(requireContext(), product.error, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun showErrorDialog(errorMessage: String) {
        AlertDialog.Builder(requireContext())
            .setMessage(errorMessage)
            .setTitle("ERROR")
            .create()
            .show()
    }

    companion object {
        fun newInstance() = ProductGeneralInfoFragment()
    }
}