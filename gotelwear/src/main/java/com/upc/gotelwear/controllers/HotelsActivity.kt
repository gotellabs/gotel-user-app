package com.upc.gotelwear.controllers

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.gotellabs.domain.model.Hotel
import com.gotellabs.domain.repository.HotelRepository
import com.upc.gotelwear.R
import com.upc.gotelwear.adapters.HotelWearAdapter

class HotelsActivity : WearableActivity() {

    private lateinit var hotels: List<Hotel>
    private lateinit var adapter: HotelWearAdapter
    private lateinit var repository: HotelRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()
//        repository=HotelRepositoryImpl()
        getHotels()

    }

    private fun getHotels() {

    }

}
