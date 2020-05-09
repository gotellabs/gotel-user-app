package com.example.upc.data.mock

import com.gotellabs.domain.model.HotelModel

class MockData {

    companion object {
        val mockHotelList = listOf(
            HotelModel(
                _id = "q28dhwwdawddwad9",
                name = "Hotel1",
                description = "Hello hotels",
                image = "https://www.perutravelling.com/images/lima/hotel-carmel-lima.jpg"
            ),
            HotelModel(
                _id = "q28dhwwdawd9adw",
                name = "Hotel2",
                description = "Hello hotels 2",
                image = "https://www.perutravelling.com/images/lima/hotel-carmel-lima.jpg"
            ),
            HotelModel(
                _id = "q28ddwadhwwdawd9",
                name = "Hotel3",
                description = "Hello hotels 3",
                image = "https://www.perutravelling.com/images/lima/hotel-carmel-lima.jpg"
            )
        )

    }

}
