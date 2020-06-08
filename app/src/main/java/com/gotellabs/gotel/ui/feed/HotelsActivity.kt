package com.gotellabs.gotel.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gotellabs.domain.model.Hotel
import com.gotellabs.gotel.R
import com.gotellabs.gotel.base.BaseActivity
import com.gotellabs.gotel.ui.detail.HotelDetailActivity
import kotlinx.android.synthetic.main.activity_hotels.*
import javax.inject.Inject

class HotelsActivity : BaseActivity<HotelsViewModel>(R.layout.activity_hotels),
    HotelsAdapter.OnItemClickListener {

    @Inject
    lateinit var factory: HotelFeedViewModelFactory

    private lateinit var hotelsAdapter: HotelsAdapter
    private val DEBUG_TAG = "HOTEL LIST"

    override fun createViewModel(): HotelsViewModel {
        return ViewModelProviders.of(this, factory).get(HotelsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        daggerInjector.createHotelFeedComponent().inject(this)
        super.onCreate(savedInstanceState)
        observeViewModel()
        viewModel.loadHotels()
        hotelsAdapter = HotelsAdapter(viewModel.hotelsLiveData.value ?: emptyList(), this)
        hotelRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HotelsActivity)
            adapter = hotelsAdapter
        }

    }

    private fun observeViewModel() {
        viewModel.hideLoadingLiveData.observe {
            progressBar.visibility = View.GONE
        }

        viewModel.showLoadingLiveData.observe {
            progressBar.visibility = View.VISIBLE
        }

        viewModel.hotelsLiveData.observe { movies ->
            hotelsAdapter.update(movies)
        }

//        viewModel.getNavigateToMovieDetails().observe { movie ->
//            MovieDetailsActivity.start(this, movie)
//        }

        viewModel.showErrorLiveData.observe { error ->
            Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        }
    }


    /**
     * Performed when an item is clicked.
     *  Goes to the hotel detail screen.
     * @param hotel Hotel model to send in Json string
     */
    override fun onItemClicked(hotel: Hotel) {
        val intent = Intent(this, HotelDetailActivity::class.java)
        intent.putExtra("hotelModel", hotel)
        startActivity(intent)
    }
}