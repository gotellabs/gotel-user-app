package com.gotellabs.gotel.ui.hotels

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.upc.data.mock.MockData
import com.gotellabs.domain.model.HotelModel
import com.gotellabs.gotel.R
import com.gotellabs.gotel.base.BaseActivity
import com.gotellabs.gotel.databinding.ActivityHotelsBinding
import com.gotellabs.gotel.utils.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class HotelsActivity : BaseActivity<HotelsViewModel, ActivityHotelsBinding>(),
    HotelsAdapter.OnItemClickListener {

    private val mAdapter: HotelsAdapter by lazy { HotelsAdapter(onItemClickListener = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)
        initHotels()
        handleNetworkChanges()

    }

    private fun handleNetworkChanges() {
        NetworkUtils.getNetworkLiveData(applicationContext).observe(this, Observer { isConnected ->
            if (!isConnected) {
                mViewBinding.statusTextViewNetworkStatus.text =
                    getString(R.string.no_internet_connection)
                mViewBinding.networkLayoutStatus.apply {
                    show()
                    setBackgroundColor(getColorRes(R.color.networkStatusNotConnected))
                }
            } else {
                mViewBinding.statusTextViewNetworkStatus.text =
                    getString(R.string.internet_available)
                mViewBinding.networkLayoutStatus.apply {
                    setBackgroundColor(getColorRes(R.color.networkStatusConnected))
                    animate().alpha(1f)
                        .setStartDelay(ANIMATION_DURATION)
                        .setDuration(ANIMATION_DURATION)
                        .setListener(object : AnimatorListenerAdapter() {
                            override fun onAnimationEnd(animation: Animator?) {
                                hide()
                            }
                        })
                }
            }
        })
    }

    private fun initHotels() {
        mViewBinding.hotelRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@HotelsActivity)
            adapter = mAdapter
        }
        mAdapter.submitList(MockData.mockHotelList)
        mViewBinding.hotelsSwipeRefreshLayout.setOnRefreshListener {
            //TODO: fetch hotels
        }
    }


    private fun showLoading(isLoading: Boolean) {
        mViewBinding.hotelsSwipeRefreshLayout.isRefreshing = isLoading
    }

    override fun getViewBinding(): ActivityHotelsBinding =
        ActivityHotelsBinding.inflate(layoutInflater)

    override fun getViewModel(): HotelsViewModel = viewModelOf(mViewModelProvider)

    override fun onItemClicked(hotel: HotelModel, imageView: ImageView) {
        this.showToast("Item clicked")
    }

    companion object {
        const val ANIMATION_DURATION = 1000.toLong()
    }
}
