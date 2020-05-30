package com.example.upc.data.mapper

import com.example.upc.data.local.HotelEntity
import com.gotellabs.domain.model.Hotel


/**
 * Created by Enzo Lizama Paredes on 5/27/20.
 * Contact: lizama.enzo@gmail.com
 */

object HotelMapper {
    fun toDomain(hotelEntity: HotelEntity): Hotel {
        return Hotel(
            _id = hotelEntity.id,
            name = hotelEntity.name,
            description = hotelEntity.description
        )
    }

    fun toEntity(hotel: Hotel): HotelEntity {
        return HotelEntity(
            id = hotel._id,
            name = hotel.name,
            description = hotel.description
        )
    }

}