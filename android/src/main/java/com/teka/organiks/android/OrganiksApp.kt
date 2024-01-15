package com.teka.organiks.android

import android.app.Application
import com.teka.organiks.android.di.androidModule
import com.teka.organiks.di.KoinInit
import io.github.aakira.napier.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class OrganiksApp : Application() {
    override fun onCreate() {
        super.onCreate()

        KoinInit().init {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@OrganiksApp)
            modules(
                listOf(
                    androidModule,
                ),
            )
        }
    }
}
