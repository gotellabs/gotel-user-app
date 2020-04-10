package com.example.upc.data.repository

import com.example.upc.data.mock.MockData
import com.gotellabs.domain.core.OperationCallback
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.repository.HotelRepository


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelRepositoryImpl : HotelRepository {

    override fun retrieveHotels(callback: OperationCallback<HotelModel>) {
        val mockHotels = MockData.mockHotelList
        if (mockHotels.isNotEmpty()) {
            callback.onSuccess(mockHotels)
        } else {
            callback.onError("No hay telos :(")
        }
    }

}