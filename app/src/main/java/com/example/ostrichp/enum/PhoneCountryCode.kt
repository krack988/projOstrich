package com.example.ostrichp.enum

import com.example.ostrichp.R
import com.example.ostrichp.utils.digits

enum class PhoneCountryCode (
    val codeValue: String,
    val codeName: String,
    val countryName: Int,
    val operatorsCodes: List<String>,
    val numberLength: Int
) {
    BY(
        "375",
        "BY",
        R.string.by,
        arrayListOf("29", "33", "44", "25"),
        9
    ),
    RU(
        "7",
        "RU",
        R.string.ru,
        arrayListOf(), 10
    ),
    OTHER(
        "",
        "",
        R.string.other,
        arrayListOf(),
        0
    );

    companion object {
        fun getValueByCodeName(codeName: String): PhoneCountryCode {
            return values().firstOrNull { it.name.lowercase() == codeName.lowercase() } ?: OTHER
        }

        fun getValueByPhoneNumber(phoneNumber: String): PhoneCountryCode {
            return runCatching {
                val numberDigits = phoneNumber.digits.orEmpty()
                return values().firstOrNull {
                    numberDigits.startsWith(it.codeValue)
                            && numberDigits.substring(it.codeValue.length).length == it.numberLength
                } ?: OTHER
            }.getOrElse { OTHER }
        }
    }
}