package com.example.upc.data.mock

import com.gotellabs.domain.model.Hotel

class MockData {

    companion object {
        val mockHotelList = listOf(
            Hotel(
                _id = "q28dhwwdawddwad9",
                name = "Hotel1",
                description = "Hello hotels"
            ),
            Hotel(
                _id = "q28dhwwdawd9adw",
                name = "Hotel2",
                description = "Hello hotels 2"
            ),
            Hotel(
                _id = "q28ddwadhwwdawd9",
                name = "Hotel3",
                description = "Hello hotels 3"
            )
        )

    }

}
