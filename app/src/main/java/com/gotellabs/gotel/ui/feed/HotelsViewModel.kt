package com.gotellabs.gotel.ui.feed

import androidx.lifecycle.MutableLiveData
import com.gotellabs.domain.core.Result
import com.gotellabs.domain.model.Hotel
import com.gotellabs.domain.usecase.GetHotelsUseCase
import com.gotellabs.gotel.base.BaseViewModel
import com.gotellabs.gotel.core.DispatcherProvider


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

class HotelsViewModel(
    private val getHotelsUseCase: GetHotelsUseCase,
    dispatcherProvider: DispatcherProvider
) : BaseViewModel(dispatcherProvider) {

    val hotelsLiveData: MutableLiveData<List<Hotel>> = MutableLiveData()
    val showLoadingLiveData: MutableLiveData<Unit> = MutableLiveData()
    val hideLoadingLiveData: MutableLiveData<Unit> = MutableLiveData()
    val showErrorLiveData: MutableLiveData<String> = MutableLiveData()

    fun loadHotels() {
        showLoadingLiveData.postValue(Unit)
        execute {
            when (val result = getHotelsUseCase.execute()) {
                is Result.Success -> {
                    hideLoadingLiveData.postValue(Unit)
                    hotelsLiveData.postValue(result.data)
                }

                is Result.Error -> {
                    hideLoadingLiveData.postValue(Unit)
                    showErrorLiveData.postValue(result.error.message)
                }
            }
        }
    }

}