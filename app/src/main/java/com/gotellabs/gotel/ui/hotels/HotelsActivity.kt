package com.gotellabs.gotel.ui.hotels

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.R
import com.gotellabs.gotel.di.ServiceLocator
import com.gotellabs.gotel.ui.hotel.HotelDetailActivity
import com.gotellabs.gotel.utils.showToast
import kotlinx.android.synthetic.main.activity_hotels.*
import kotlinx.android.synthetic.main.layout_error.*

class HotelsActivity : AppCompatActivity(), HotelsAdapter.OnItemClickListener {

    private lateinit var hotelsAdapter: HotelsAdapter
    private lateinit var viewModel: HotelsViewModel
    private val DEBUG_TAG = "HOTEL LIST"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotels)
        setupViewModel()
        setupUi()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ServiceLocator.provideViewModelFactory()
        ).get(HotelsViewModel::class.java)
        viewModel.hotels.observe(this, renderHotels)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }

    private fun setupUi() {
        hotelsAdapter = HotelsAdapter(viewModel.hotels.value ?: emptyList(), this)
        hotelRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HotelsActivity)
            adapter = hotelsAdapter
        }
    }

    private val renderHotels = Observer<List<HotelModel>> {
        Log.v(DEBUG_TAG, "data updated $it")
        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.GONE
        hotelsAdapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v(DEBUG_TAG, "isViewLoading $it")
        val visibility = if (it) View.VISIBLE else View.GONE
        progressBar.visibility = visibility
    }

    @SuppressLint("SetTextI18n")
    private val onMessageErrorObserver = Observer<Any> { it ->
        Log.v(DEBUG_TAG, "onMessageError $it")
        layoutError.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE
        textViewError.text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
        Log.v(DEBUG_TAG, "emptyListObserver $it")
        layoutEmpty.visibility = View.VISIBLE
        layoutError.visibility = View.GONE
    }


    override fun onResume() {
        super.onResume()
        viewModel.getHotels()
    }


    /**
     * Performed when an item is clicked.
     *  Goes to the hotel detail screen.
     * @param hotel Hotel model to send in Json string
     */
    override fun onItemClicked(hotel: HotelModel) {

        val intent = Intent(this, HotelDetailActivity::class.java)
        intent.putExtra("hotelModel", hotel)
        startActivity(intent)

    }

}
