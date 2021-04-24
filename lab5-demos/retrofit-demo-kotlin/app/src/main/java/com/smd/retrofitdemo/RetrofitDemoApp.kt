package com.smd.retrofitdemo

import android.app.Application
import timber.log.Timber

class RetrofitDemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}