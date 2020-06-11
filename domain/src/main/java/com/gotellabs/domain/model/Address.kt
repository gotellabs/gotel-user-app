package com.gotellabs.domain.model

import java.io.Serializable


/**
 * Created by Enzo Lizama Paredes on 5/10/20.
 * Contact: lizama.enzo@gmail.com
 */
data class Address(
    val number: String = "1234567",
    val district: String = "Lima",
    val city: String = "Lima",
    val country: String = "Peru",
    val zipcode: String = "LIMA 19",
    val street: String = "STREET",
    val lat: String = "-12.0521471",
    val lng: String = "-76.9673025"
) : Serializable
