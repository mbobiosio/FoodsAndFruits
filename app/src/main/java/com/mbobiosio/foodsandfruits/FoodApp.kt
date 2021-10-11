package com.mbobiosio.foodsandfruits

import android.app.Application
import com.intuit.sdp.BuildConfig
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Oct 11, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class FoodApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //initialise logger
        initLogger()
    }

    private fun initLogger() {
        Timber.plant(Timber.DebugTree())
    }
}