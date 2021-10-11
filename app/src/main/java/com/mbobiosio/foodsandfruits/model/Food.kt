package com.mbobiosio.foodsandfruits.model

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
data class Food(
    val id: Int?,
    val productName: String?,
    val image: Int?,
    val from: String?,
    val nutrients: String?,
    val quantity: String?,
    val price: Double?,
    val isOrganic: Boolean?,
    val description: String?
)
