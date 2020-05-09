package com.example.upc.data.remote

import com.example.upc.data.remote.response.HotelResponse
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