package com.mbobiosio.foodsandfruits.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.textview.MaterialTextView
import com.mbobiosio.foodsandfruits.R
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
@BindingAdapter("price")
fun MaterialTextView.price(price: String?) {
    price?.let {
        //val priceFormat = DecimalFormat("###,###,##0.00")
        this.text = resources.getString(R.string.price_format, currencyFormat(it))
    }
}

@BindingAdapter("isOrganic")
fun MaterialTextView.foodType(status: Boolean?) {
    when (status) {
        true -> this.text = context.getString(R.string.organic)
        else -> this.text = context.getString(R.string.not_organic)
    }
}

@BindingAdapter("foodImage")
fun MaterialTextView.foodImage(image: String?) {
    Timber.d(image)
    this.text = image
}

@BindingAdapter("productImage")
fun ImageView.productImage(name: String?) {
    name?.let {
        Timber.d(it)
        when {
            it.contains("baby carrots", ignoreCase = true) -> {
                this.load("https://res.cloudinary.com/s-s-r-s-1-s-ne-y-r-mqg-i-ymr-dm-h-l-ul-am-h-t-w-v-i-2-w-9-b-l-4-e-ux-z-u-8-t-t-5j-b-r-vj-5-z-aqy-o-hs-h-w-v-fu7-dz/image/upload/v1633964295/carrots-1296x728-feature_gw1apd.jpg")
            }
            it.contains("Avocados", ignoreCase = true) -> {
                this.load("https://res.cloudinary.com/s-s-r-s-1-s-ne-y-r-mqg-i-ymr-dm-h-l-ul-am-h-t-w-v-i-2-w-9-b-l-4-e-ux-z-u-8-t-t-5j-b-r-vj-5-z-aqy-o-hs-h-w-v-fu7-dz/image/upload/v1633963534/Sliced_Fresh_Avocado_mzspyf.jpg")
            }
            it.contains("sheep cheese", ignoreCase = true) -> {
                this.load("https://res.cloudinary.com/s-s-r-s-1-s-ne-y-r-mqg-i-ymr-dm-h-l-ul-am-h-t-w-v-i-2-w-9-b-l-4-e-ux-z-u-8-t-t-5j-b-r-vj-5-z-aqy-o-hs-h-w-v-fu7-dz/image/upload/v1633963635/how-to-make-sheep-milk-cheese_qt75bx.jpg")
            }
            it.contains("broccoli", ignoreCase = true) -> {
                this.load("https://res.cloudinary.com/s-s-r-s-1-s-ne-y-r-mqg-i-ymr-dm-h-l-ul-am-h-t-w-v-i-2-w-9-b-l-4-e-ux-z-u-8-t-t-5j-b-r-vj-5-z-aqy-o-hs-h-w-v-fu7-dz/image/upload/v1633964205/130-apollo-broccoli-seed-130-sjeme-original-imafy6gumjeukmwy_ip4uth.jpg")
            }
            it.contains("Sweet Corncobs") -> {
                this.load("https://res.cloudinary.com/s-s-r-s-1-s-ne-y-r-mqg-i-ymr-dm-h-l-ul-am-h-t-w-v-i-2-w-9-b-l-4-e-ux-z-u-8-t-t-5j-b-r-vj-5-z-aqy-o-hs-h-w-v-fu7-dz/image/upload/v1633964359/boiled-corn-horizontal-1539104513_weudvo.png")
            }
            else -> {

            }
        }
    }
}