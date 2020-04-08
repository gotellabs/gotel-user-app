package com.gotellabs.gotel.ui.hotels

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.upc.data.mock.MockData
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.base.BaseActivity
import com.gotellabs.gotel.databinding.ActivityHotelsBinding
import com.gotellabs.gotel.utils.viewModelOf

class HotelsActivity : BaseActivity<HotelsViewModel, ActivityHotelsBinding>(),
    HotelsAdapter.OnItemClickListener {

    val hotels: List<HotelModel> = MockData.mockHotelList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        initHotels()

        handleNetworkChanges()

    }

    private fun handleNetworkChanges() {
        TODO("Not yet implemented")
    }

    private fun initHotels() {
        TODO("Not yet implemented")
    }

    override fun getViewBinding(): ActivityHotelsBinding =
        ActivityHotelsBinding.inflate(layoutInflater)

    override fun getViewModel(): HotelsViewModel = viewModelOf<HotelsViewModel>(mViewModelProvider)
    override fun onItemClicked(hotel: HotelModel, imageView: ImageView) {
        Log.d("HOTEL DETAIL", hotel.toString())
    }

    companion object {
        const val ANIMATION_DURATION = 1000.toLong()
    }
}
