package com.example.ostrichp.utils

import java.util.*

object LatinSymbolTransform {

    fun transform(sym: Char): String {
        val isUpperCase = sym.isUpperCase()
        val res = when (sym.uppercaseChar()) {
            'А' -> "A"
            'Б' -> "B"
            'В' -> "V"
            'Г' -> "G"
            'Д' -> "D"
            'Е' -> "E"
            'Ё' -> "E"
            'Ж' -> "ZH"
            'З' -> "Z"
            'И' -> "I"
            'Й' -> "I"
            'К' -> "K"
            'Л' -> "L"
            'М' -> "M"
            'Н' -> "N"
            'О' -> "O"
            'П' -> "P"
            'Р' -> "R"
            'С' -> "S"
            'Т' -> "T"
            'У' -> "U"
            'Ф' -> "F"
            'Х' -> "KH"
            'Ц' -> "TS"
            'Ч' -> "CH"
            'Ш' -> "SH"
            'Щ' -> "SHSC"
            'Ъ' -> "IE"
            'Ы' -> "Y"
            'Э' -> "E"
            'Ю' -> "IU"
            'Я' -> "IA"
            else -> sym.toString()
        }
        return if (isUpperCase) res else res.lowercase(Locale.getDefault())
    }

}