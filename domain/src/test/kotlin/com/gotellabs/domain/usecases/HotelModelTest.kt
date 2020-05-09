package com.gotellabs.domain.usecases

import com.gotellabs.domain.model.HotelModel
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


/**
 * Created by Enzo Lizama Paredes on 5/8/20.
 * Contact: lizama.enzo@gmail.com
 */

@RunWith(JUnit4::class)
class HotelModelTest {

    @Test
    fun hotelModelAttributesValidation() {
        val hotel = HotelModel(
            _id = "id test",
            name = "name test",
            description = "description test",
            image = "image test",
            phone = "phone test",
            rate = "rate test"
        )
        assertNotNull(hotel)
    }
}