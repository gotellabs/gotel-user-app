package com.upc.gotelwear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import androidx.wear.widget.WearableLinearLayoutManager
import com.example.upc.data.mock.MockData
import com.upc.gotelwear.adapters.HotelWearAdapter
import kotlinx.android.synthetic.main.activity_main.*

class HotelsActivity : WearableActivity() {

    private lateinit var hotelsAdapter: HotelWearAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAmbientEnabled()
        getHotels()
    }

    private fun getHotels() {
        hotelsAdapter = HotelWearAdapter(MockData.mockHotelList, this)
        hotelRecyclerViewWear.isCircularScrollingGestureEnabled = true
        hotelRecyclerViewWear.apply {
            layoutManager = WearableLinearLayoutManager(this@HotelsActivity)
            isEdgeItemsCenteringEnabled = true
            adapter = hotelsAdapter
        }
    }

}
