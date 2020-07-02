package com.upc.gotelwear.controllers

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import com.upc.gotelwear.network.HotelRepositoryImpl
import com.upc.gotelwear.network.OperationCallback
import com.gotellabs.domain.model.Hotel
import com.upc.gotelwear.network.HotelRepository
import com.upc.gotelwear.R
import com.upc.gotelwear.adapters.HotelWearAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HotelsActivity : WearableActivity() {

    private lateinit var hotels: List<Hotel>
    private lateinit var adapter : HotelWearAdapter
    private lateinit var repository: HotelRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()
        repository= HotelRepositoryImpl()

        getHotels()

    }

    fun getHotels() {

        repository.retrieveHotels(object :
            OperationCallback<Hotel> {
            override fun onSuccess(data: List<Hotel>) {
                hotels = data
                hotelRecyclerViewWear.layoutManager= WearableLinearLayoutManager(this@HotelsActivity)
                hotelRecyclerViewWear.isEdgeItemsCenteringEnabled=true

                adapter= HotelWearAdapter(hotels,this@HotelsActivity)
                hotelRecyclerViewWear.adapter=adapter
            }

            override fun onError(error: String?) {
                print("Error")
            }

        })
    }

    fun dataMock(): List<Hotel>{
        var hotelsMock: List<Hotel> = listOf(
            Hotel("Picasso",
                "Hotel 5mentarios" ,
                "Loremmmmm"),
            Hotel("Picasso",
                "Hotel ASDASD" ,
                "Loremmmmm"),
            Hotel("Picasso",
            "Hotel MAJDAJSD" ,
            "Loremmmmm")
        )
        return hotelsMock
    }

}
