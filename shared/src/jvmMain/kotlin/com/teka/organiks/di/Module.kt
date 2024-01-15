package com.teka.organiks.di

import com.teka.organiks.platform.DatabaseDriverFactory
import com.teka.organiks.platform.MultiplatformSettingsWrapper
import com.teka.organiks.platform.NotificationsManager
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { MultiplatformSettingsWrapper().createSettings() }
    single { DatabaseDriverFactory() }
    single { NotificationsManager() }
}
