package com.example.ostrichp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.Settings
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import androidx.core.content.res.ResourcesCompat
import com.example.ostrichp.R

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

    fun CharSequence?.makeSelectedAfterFirstSpaces(
        resources: Resources,
        spaces: Int = 1
    ): CharSequence? {
        if (this == null) return this
        if (spaces < 1) return this
        var startPos = -1
        var count = 0
        this.forEachIndexed { index, c ->
            if (c == ' ') {
                count++
                if (count == spaces) startPos = index
            }
        }
        return if (startPos in this.indices) {
            val result = SpannableString(this)
            result.setSpan(
                ForegroundColorSpan(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.error,
                        null
                    )
                ), startPos, this.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            result
        } else this
    }

}

fun String?.format2Lines(): String? {
    return if (this.orEmpty().contains('\n')) this
    else this?.replaceFirst(' ', '\n')
}
