package com.example.upc.data.local.database

import com.example.upc.data.local.dao.HotelDao
import com.example.upc.data.local.entity.HotelEntity
import com.gotellabs.domain.model.HotelModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */
// TODO: Mapper from [HotelEntity] to [HotelModel]
class HotelDatabaseClient(private val hotelDao: HotelDao) : HotelDatabase {
    override suspend fun getAll(): List<HotelModel> {
        return withContext(IO) {
            hotelDao.getAll().map { hotel ->
                HotelModel(
                    id = hotel.id,
                    name = hotel.name,
                    image = hotel.image,
                    description = hotel.description
                )
            }
        }
    }

    override suspend fun insert(hotel: HotelModel) {
        return withContext(IO) {
            hotelDao.insert(
                HotelEntity(
                    id = hotel.id,
                    name = hotel.name,
                    description = hotel.description,
                    image = hotel.image
                )
            )
        }
    }

    override suspend fun delete(hotel: HotelModel) {
        return withContext(IO) {
            hotelDao.delete(
                HotelEntity(
                    id = hotel.id,
                    name = hotel.name,
                    description = hotel.description,
                    image = hotel.image
                )
            )
        }
    }

    override suspend fun deleteAll() {
        return withContext(IO) {
            hotelDao.deleteAll()
        }
    }

}