package com.mbobiosio.foodsandfruits.listener

import com.mbobiosio.foodsandfruits.model.Fruits

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
interface FoodClickListener {
    fun onItemClicked(fruits: Fruits)
}