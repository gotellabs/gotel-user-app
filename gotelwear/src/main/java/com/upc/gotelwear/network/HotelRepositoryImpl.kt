package com.upc.gotelwear.network

import android.util.Log
import com.gotellabs.domain.model.Hotel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by Enzo Lizama Paredes on 4/9/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelRepositoryImpl: HotelRepository {

    private lateinit var api: Call<HotelResponse>
    override fun retrieveHotels(callback: OperationCallback<Hotel>) {
        api = ApiClient.build().fetchHotels()
        api.enqueue(object : Callback<HotelResponse> {

            override fun onFailure(call: Call<HotelResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<HotelResponse>, response: Response<HotelResponse>) {
                response.body()?.let {
                    if (response.isSuccessful && it.isSuccess()) {
                        Log.v("CONSOLE", "data ${it.data}")
                        callback.onSuccess(it.data)
                    } else {
                        callback.onError("OBJECT ERROR")
                    }
                }
            }

        })
    }

    override fun cancel() {
        api.cancel()
    }
}