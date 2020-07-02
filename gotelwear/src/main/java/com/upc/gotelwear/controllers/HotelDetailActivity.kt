package com.upc.gotelwear.controllers

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.Hotel
import com.upc.gotelwear.R
import kotlinx.android.synthetic.main.activity_hotel_detail.*

class HotelDetailActivity : WearableActivity() {

    private lateinit var hotel: Hotel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)
        hotel = intent.extras!!.get("hotel") as Hotel
        // Enables Always-on
        setAmbientEnabled()

        description.text=hotel.description
        Glide
            .with(this)
            .load(hotel.photos[0].imageUrl)
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(imageView)

    }
}