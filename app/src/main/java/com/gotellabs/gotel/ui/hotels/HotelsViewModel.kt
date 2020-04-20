package com.gotellabs.gotel.ui.hotels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.upc.data.repository.HotelRepositoryImpl
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.usecases.RetrieveHotelsUseCase
import com.gotellabs.gotel.utils.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

@ExperimentalCoroutinesApi
class HotelsViewModel @Inject constructor(

) : ViewModel() {

    private var retrieveHotelsUseCase: RetrieveHotelsUseCase =
        RetrieveHotelsUseCase(HotelRepositoryImpl())
/* private val searchHotelsUseCase: SearchHotelsUseCase */

    private val _hotelLiveData = MutableLiveData<State<List<HotelModel>>>()
    val hotelLiveData: LiveData<State<List<HotelModel>>>
        get() = _hotelLiveData

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

    fun getHotels() {
        viewModelScope.launch {
            retrieveHotelsUseCase()
        }
    }

}