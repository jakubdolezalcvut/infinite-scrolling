package com.dolezal.infinite

import android.app.Application
import com.facebook.stetho.Stetho
import toothpick.Toothpick

class InfiniteApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Toothpick.openScope(applicationContext).apply {
            installModules(PagingToothpickModule)
        }
        Stetho.initializeWithDefaults(this);
    }
}