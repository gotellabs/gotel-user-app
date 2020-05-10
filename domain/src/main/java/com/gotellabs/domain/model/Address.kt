package com.gotellabs.domain.model

import java.io.Serializable


/**
 * Created by Enzo Lizama Paredes on 5/10/20.
 * Contact: lizama.enzo@gmail.com
 */
data class Address(
    val number: String,
    val district: String,
    val city: String,
    val country: String,
    val zipcode: String,
    val street: String
) : Serializable
