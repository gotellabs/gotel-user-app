package com.gotellabs.domain.repository

import com.gotellabs.domain.core.OperationCallback
import com.gotellabs.domain.model.HotelModel


/**
 * Created by Enzo Lizama Paredes on 4/6/20.
 * Contact: lizama.enzo@gmail.com
 */


interface HotelRepository {
    fun retrieveHotels(callback: OperationCallback<HotelModel>)
}