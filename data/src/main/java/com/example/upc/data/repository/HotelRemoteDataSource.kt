package com.example.upc.data.repository

import android.util.Log
import com.example.upc.data.remote.GotelService
import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 5/24/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelRemoteDataSource(private val hotelApi: GotelService) : HotelDataSource.Remote {
    override suspend fun getHotels(): Result<List<Hotel>> {
        return try {
            val result = hotelApi.fetchHotelsAsync().await()
            Log.d("HOTELS-info", result.data.toString())
            Result.Success(result.data)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}