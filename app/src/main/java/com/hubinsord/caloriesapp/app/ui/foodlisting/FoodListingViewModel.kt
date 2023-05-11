package com.hubinsord.caloriesapp.app.ui.foodlisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.ProductInfo
import com.hubinsord.caloriesapp.core.domain.entities.Resource
import com.hubinsord.caloriesapp.core.domain.interfaces.OpenFoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodListingViewModel @Inject constructor(
    private val repository: OpenFoodRepository
) : ViewModel() {

    private val _products = MutableLiveData<Resource<List<Product>>>()
    val products: LiveData<Resource<List<Product>>> get() = _products

    private fun getProducts(productName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _products.postValue(Resource.Loading())
            _products.postValue(
                repository.getProductsByName(
                    productName = productName,
                    shouldFetchFromRemote = false
                )
            )
        }
    }

    fun onSearchProductTextChanged(productName: CharSequence?) {
        getProducts(productName.toString())
    }

    fun onFabInsertProductsClicked() {
        products.value?.also {
        }
    }

    fun onIvSearchClicked(productName: String) {
        getProducts(productName)
    }
}