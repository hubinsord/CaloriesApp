package com.hubinsord.caloriesapp.app.ui.foodlisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.interfaces.OpenFoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodListingViewModel @Inject constructor(
    private val repository: OpenFoodRepository
) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val _productInfo = MutableLiveData<ProductInfo>()
    val productInfo: LiveData<ProductInfo> get() = _productInfo

    private fun getProducts(productName: String) =
        viewModelScope.launch {
            _products.postValue(repository.getProductsByName(productName))
//            _productInfo.postValue(repository.getProductsFromProductInfo())
        }

    fun onSearchProductTextChanged(productName: CharSequence?) {
        getProducts(productName.toString())
    }
}