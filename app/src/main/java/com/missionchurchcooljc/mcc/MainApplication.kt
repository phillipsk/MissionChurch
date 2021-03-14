package com.missionchurchcooljc.mcc

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application(){

    init {
        Log.d("LIFECYCLE", "{${this.javaClass.simpleName}} Class Created")
    }
}