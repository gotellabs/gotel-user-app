package com.upc.gotelwear.network

import com.upc.gotelwear.network.HotelResponse
import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */


interface RetrofitService {
    @GET("/webApi/hotels/fetch")
    fun fetchHotels(): Call<HotelResponse>
}