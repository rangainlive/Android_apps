package com.proud_indian.planit

import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}