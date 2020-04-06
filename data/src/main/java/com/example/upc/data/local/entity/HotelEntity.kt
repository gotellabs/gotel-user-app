package com.example.upc.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Enzo Lizama Paredes on 4/5/20.
 * Contact: lizama.enzo@gmail.com
 */

@Entity(tableName = "hotel")
class HotelEntity(
    @PrimaryKey
    var id: Int,
    var name: String,
    var description: String,
    var image: String
)