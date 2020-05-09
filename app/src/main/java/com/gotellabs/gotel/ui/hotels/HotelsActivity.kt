package com.gotellabs.gotel.ui.hotels

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upc.data.mock.MockData.Companion.mockHotelList
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.R
import com.gotellabs.gotel.utils.showToast
import kotlinx.android.synthetic.main.activity_hotels.*

class HotelsActivity : AppCompatActivity(), HotelsAdapter.OnItemClickListener {

    private lateinit var hotelsAdapter: HotelsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)
        initHotels()
    }


    private fun initHotels() {
        hotelsAdapter = HotelsAdapter(mockHotelList, this)
        hotelRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HotelsActivity)
            adapter = hotelsAdapter
        }

        hotelsSwipeRefreshLayout.setOnRefreshListener {
            //TODO: fetch hotels
        }
    }

    private fun setupUi() {

    }


    override fun onItemClicked(hotel: HotelModel, imageView: ImageView) {
        this.showToast("Item clicked")
    }

}
