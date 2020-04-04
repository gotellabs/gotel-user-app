package com.gotellabs.gotel.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import dagger.android.AndroidInjection
import javax.inject.Inject


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */


abstract class BaseActivity<VM : ViewModel, VB : ViewBinding> : AppCompatActivity() {
    @Inject
    protected lateinit var mViewModelProvider: ViewModelProvider.Factory

    protected val mViewModel by lazy { getViewModel() }
    protected lateinit var mViewBinding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        mViewBinding = getViewBinding()
    }


    abstract fun getViewBinding(): VB

    abstract fun getViewModel(): VM

}