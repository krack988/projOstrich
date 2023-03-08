package com.example.ostrichp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

object Utils {

    fun openAppInStore(context: Activity?, appId: String): Boolean {
        return runCatching {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://play.google.com/store/apps/details?id=$appId")
            )
            context?.startActivity(intent)
            true
        }.getOrDefault(false)
    }

    fun openLocationSettings(context: Context?): Boolean {
        return runCatching {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            context?.startActivity(intent)
            true
        }.getOrDefault(false)
    }

}