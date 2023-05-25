package com.hubinsord.caloriesapp.app.ui.productdashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hubinsord.caloriesapp.core.domain.entities.Product
import com.hubinsord.caloriesapp.core.domain.entities.Resource
import com.hubinsord.caloriesapp.core.domain.interfaces.OpenFoodRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductGeneralInfoViewModel @Inject constructor(
    private val openFoodRepository: OpenFoodRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val barcode: String = savedStateHandle.get<String>("barcode") ?: ""

    private val _product = MutableLiveData<Resource<Product>>()
    val product: LiveData<Resource<Product>> get() = _product

    fun getProduct() {
        viewModelScope.launch {
            _product.postValue(Resource.Loading())
            _product.postValue(openFoodRepository.getProduct(barcode))
        }
    }
}
