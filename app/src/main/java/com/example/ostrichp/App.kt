package com.example.ostrichp

import android.app.Application
import com.airbnb.lottie.Lottie
import com.airbnb.lottie.LottieConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        Lottie.initialize(
            LottieConfig.Builder()
                .setEnableSystraceMarkers(true)
                .build()
        )

    }
}