package com.gotellabs.gotel.ui.rating

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gotellabs.gotel.R
import com.hsalf.smilerating.SmileRating
import kotlinx.android.synthetic.main.activity_rating.*
import timber.log.Timber

class RatingActivity : AppCompatActivity() {

    var rate: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rating)

        smile_rating.setOnSmileySelectionListener { smiley, reselected ->
            when (smiley) {
                SmileRating.TERRIBLE -> {
                    Timber.i("Terrible")
                    rate = 1
                }
                SmileRating.BAD -> {
                    Timber.i("Bad")
                    rate = 2
                }
                SmileRating.OKAY -> {
                    Timber.i("Okay")
                    rate = 3
                }
                SmileRating.GOOD -> {
                    Timber.i("Good")
                    rate = 4
                }
                SmileRating.GREAT -> {
                    Timber.i("Great")
                    rate = 5
                }
            }
        }

        send_opinion.setOnClickListener {
            Toast.makeText(this, getString(R.string.thanks), Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}