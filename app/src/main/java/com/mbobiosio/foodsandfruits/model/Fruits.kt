package com.mbobiosio.foodsandfruits.model

import java.io.Serializable

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Fruits(
    val id: Int?,
    val productName: String?,
    val image: String?,
    val from: String?,
    val nutrients: String?,
    val quantity: String?,
    val price: String?,
    val organic: Boolean?,
    val description: String?
): Serializable