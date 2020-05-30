package com.gotellabs.gotel.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
//        if(hotel.hotelPhotos.isNotEmpty()){
//            Glide
//                .with(this)
//                .load(hotel.hotelPhotos[0].imageUrl)
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(hotelImageView)
//        }else{
//            Glide
//                .with(this)
//                .load("https://www.ahstatic.com/hotelPhotos/9399_ho_00_p_1024x768.jpg")
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(hotelImageView)
//        }

        hotelName.text = hotel.name
        hotelDescription.text = hotel.description
        hotelPhone.text = hotel.phone
        hotelAddress.text = hotel.address!!.street + hotel.address!!.number
        hotelRate.text = hotel.rate
    }
}
