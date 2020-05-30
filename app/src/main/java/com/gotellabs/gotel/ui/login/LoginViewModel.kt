package com.gotellabs.gotel.ui.login

import com.gotellabs.domain.usecase.GetHotelsUseCase
import com.gotellabs.gotel.base.BaseViewModel
import com.gotellabs.gotel.core.DispatcherProvider


/**
 * Created by Enzo Lizama Paredes on 5/28/20.
 * Contact: lizama.enzo@gmail.com
 */

class LoginViewModel internal constructor(
    private val getHotelsUseCase: GetHotelsUseCase,
    dispatchers: DispatcherProvider
) : BaseViewModel(dispatchers)