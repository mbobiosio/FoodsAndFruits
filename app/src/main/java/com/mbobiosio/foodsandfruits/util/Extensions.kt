package com.mbobiosio.foodsandfruits.util

import android.content.Context
import timber.log.Timber
import java.io.IOException
import java.nio.charset.Charset

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
fun loadFoodsFromAsset(context: Context?): String {
    var json = ""
    context?.let {
        try {

            val inputStream = context.assets.open("data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        } catch (e: IOException) {
            Timber.d(e)
            return ""
        }
    }
    return json
}