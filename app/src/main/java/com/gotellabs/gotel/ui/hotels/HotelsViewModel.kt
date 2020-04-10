package com.gotellabs.gotel.ui.hotels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.utils.State
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelsViewModel @Inject constructor() : ViewModel() {

    private val _hotelLiveData = MutableLiveData<State<List<HotelModel>>>()
    val hotelLiveData: LiveData<State<List<HotelModel>>>
        get() = _hotelLiveData

    private val _isEmptyList = MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList

}