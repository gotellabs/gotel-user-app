package com.gotellabs.domain.usecases

import com.gotellabs.domain.model.Address
import com.gotellabs.domain.model.Hotel
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
        val hotel = Hotel(
            _id = "id test",
            name = "name test",
            description = "description test",
            phone = "phone test",
            rate = "rate test"
        )
        assertNotNull(hotel._id)
        assertNotNull(hotel.name)
        assertNotNull(hotel.description)
        assertNotNull(hotel.description)
        assertNotNull(hotel.phone)
        assertNotNull(hotel.rate)
    }

    @Test
    fun addressModelAttributesValidation() {
        val address = Address(
            number = "12",
            district = "SJL",
            city = "Lima",
            country = "Peru",
            lat = "123.32",
            lng = "124.12",
            street = "Las fresas",
            zipcode = "12201"
        )
        assertNotNull(address.number)
        assertNotNull(address.district)
        assertNotNull(address.city)
        assertNotNull(address.country)
        assertNotNull(address.lat)
        assertNotNull(address.lng)
        assertNotNull(address.street)
        assertNotNull(address.zipcode)
    }
}