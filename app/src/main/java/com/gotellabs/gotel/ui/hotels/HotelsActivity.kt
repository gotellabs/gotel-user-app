package com.gotellabs.gotel.ui.hotels

import android.os.Bundle
import android.widget.ImageView
import com.example.upc.data.mock.MockData
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.base.BaseActivity
import com.gotellabs.gotel.databinding.ActivityHotelsBinding
import com.gotellabs.gotel.utils.viewModelOf

class HotelsActivity : BaseActivity<HotelsViewModel, ActivityHotelsBinding>(), OnItemClickListener {

    val hotels: List<HotelModel> = MockData.mockHotelList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

    }

    override fun getViewBinding(): ActivityHotelsBinding =
        ActivityHotelsBinding.inflate(layoutInflater)

    override fun getViewModel(): HotelsViewModel = viewModelOf<HotelsViewModel>(mViewModelProvider)
    override fun onItemClicked(hotel: HotelModel, imageView: ImageView) {

    }
}
