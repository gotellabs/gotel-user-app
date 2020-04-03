package com.gotellabs.gotel.ui.hotels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gotellabs.domain.HotelModel
import com.gotellabs.gotel.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val hotel = HotelModel(id = 1, name = "Hotel1", description = "Hello")
        hello_text.text = hotel.description
    }
}
