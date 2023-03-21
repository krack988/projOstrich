package com.example.ostrichp.test

import javax.inject.Inject

class TestObj @Inject constructor() {

    fun getTestValue(): String {
        return "test value"
    }

}