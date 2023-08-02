package com.example.ostrichp.common

interface IViewRenderer<STATE> {
    fun render(state: STATE)
}