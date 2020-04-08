package com.gotellabs.gotel.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 * Created by Enzo Lizama Paredes on 4/6/20.
 * Contact: lizama.enzo@gmail.com
 */

object NetworkUtils {
    private val networkLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun getNetworkLiveData(context: Context): LiveData<Boolean> {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onUnavailable() {
                networkLiveData.postValue(false)
            }

            override fun onAvailable(network: Network) {
                networkLiveData.postValue(true)
            }
        }



        return networkLiveData
    }
}