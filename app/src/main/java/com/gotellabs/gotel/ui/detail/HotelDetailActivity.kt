package com.gotellabs.gotel.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.Hotel
import com.gotellabs.gotel.R
import kotlinx.android.synthetic.main.activity_hotel_detail.*

class HotelDetailActivity : AppCompatActivity() {

    private lateinit var hotel: Hotel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)
        hotel = intent.extras!!.get("hotelModel") as Hotel
        initUI()
    }

    private fun initUI() {
        if (hotel.photos.isNotEmpty()) {
            Glide
                .with(this)
                .load(hotel.photos[0].imageUrl)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(hotelImageView)
        } else {
            Glide
                .with(this)
                .load("https://r-cf.bstatic.com/images/hotel/max1024x768/210/210875998.jpg")
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(hotelImageView)
        }

        hotelName.text = hotel.name
        hotelDescription.text = hotel.description
        hotelPhone.text = hotel.phone
        hotelRate.text = hotel.rate
    }
}
