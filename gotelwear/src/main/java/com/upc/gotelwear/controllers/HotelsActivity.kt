package com.upc.gotelwear.controllers

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import com.example.upc.data.repository.HotelRepositoryImpl
import com.gotellabs.domain.core.OperationCallback
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.domain.repository.HotelRepository
import com.upc.gotelwear.R
import com.upc.gotelwear.adapters.HotelWearAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HotelsActivity : WearableActivity() {

    private lateinit var hotels: List<HotelModel>
    private lateinit var adapter : HotelWearAdapter
    private lateinit var repository: HotelRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()
        repository=HotelRepositoryImpl()

        getHotels()

    }

    fun getHotels() {

        repository.retrieveHotels(object : OperationCallback<HotelModel> {
            override fun onSuccess(data: List<HotelModel>) {
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

    fun dataMock(): List<HotelModel>{
        var hotelsMock: List<HotelModel> = listOf(
            HotelModel("Picasso",
                "Hotel 5mentarios" ,
                "Loremmmmm"),
            HotelModel("Picasso",
                "Hotel ASDASD" ,
                "Loremmmmm"),
            HotelModel("Picasso",
            "Hotel MAJDAJSD" ,
            "Loremmmmm")
        )
        return hotelsMock
    }

}
