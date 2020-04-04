package com.gotellabs.gotel.utils

import android.app.Activity
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat


/**
 * Created by Enzo Lizama Paredes on 4/3/20.
 * Contact: lizama.enzo@gmail.com
 */

/**
 * Show a [Toast] from every [Activity]
 *
 * @param message Message that will show the toast
 * @param duration Duration of the [Toast], default LENGTH_SHORT
 */
fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(applicationContext, message, duration).show()
}

/**
 * Get a color from res folder in an Activity
 *
 * @param id Color identifier from resources files
 */
fun Activity.getColor(@ColorRes id: Int) = ContextCompat.getColor(applicationContext, id)



