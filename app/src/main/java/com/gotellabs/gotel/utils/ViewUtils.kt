package com.gotellabs.gotel.utils

import android.view.View


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

/**
 * Show a [View] from UI
 *
 */
fun View.show() {
    visibility = View.VISIBLE
}

/**
 * Hide a [View] from UI
 *
 */
fun View.hide() {
    visibility = View.INVISIBLE
}
