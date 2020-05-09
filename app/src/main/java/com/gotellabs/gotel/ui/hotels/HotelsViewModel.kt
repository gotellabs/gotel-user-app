package com.gotellabs.gotel.ui.hotels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gotellabs.domain.core.OperationCallback
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelsViewModel(private val repository: HotelRepository) : ViewModel() {

    private val _hotels = MutableLiveData<List<HotelModel>>().apply { value = emptyList() }
    val hotels: LiveData<List<HotelModel>> = _hotels

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    fun getHotels() {
        _isViewLoading.postValue(true)
        repository.retrieveHotels(object : OperationCallback<HotelModel> {
            override fun onSuccess(data: List<HotelModel>) {
                _isViewLoading.postValue(false)
                if (data.isEmpty()) {
                    _isEmptyList.postValue(true)
                } else {
                    _hotels.value = data
                }
            }

            override fun onError(error: String?) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(error)
            }

        })
    }

}