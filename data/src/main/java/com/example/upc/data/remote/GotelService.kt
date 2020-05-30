package com.example.upc.data.remote

import com.example.upc.data.remote.response.HotelResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */


interface GotelService {
    @GET("/webApi/hotels/fetch")
    fun fetchHotelsAsync(): Deferred<HotelResponse>
}