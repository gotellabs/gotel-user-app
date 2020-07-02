package com.gotellabs.gotel.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gotellabs.domain.model.Hotel
import com.gotellabs.gotel.R
import com.gotellabs.gotel.ui.maps.MapsDirectionsActivity
import com.gotellabs.gotel.ui.rating.RatingActivity
import kotlinx.android.synthetic.main.activity_hotel_detail.*

class HotelDetailActivity : AppCompatActivity() {

    private lateinit var hotel: Hotel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)
        hotel = intent.extras!!.get("hotelModel") as Hotel
        initUI()

        btnGoToHotel.setOnClickListener {
            val intent = Intent(this, MapsDirectionsActivity::class.java)
            intent.putExtra("lat", hotel.address.lat)
            intent.putExtra("lng", hotel.address.lng)
            startActivity(intent)
        }

        detailHotelRateHotelBtn.setOnClickListener {
            val intent = Intent(this, RatingActivity::class.java)
            startActivity(intent)
        }

        hotelPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + hotelPhone.text.toString()))
            startActivity(intent)
        }
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
