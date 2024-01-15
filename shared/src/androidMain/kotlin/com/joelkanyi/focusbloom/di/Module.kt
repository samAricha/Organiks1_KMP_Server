package com.joelkanyi.focusbloom.di

import com.joelkanyi.focusbloom.platform.DatabaseDriverFactory
import com.joelkanyi.focusbloom.platform.MultiplatformSettingsWrapper
import com.joelkanyi.focusbloom.platform.NotificationsManager
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module = module {
    single { MultiplatformSettingsWrapper(context = get()).createSettings() }
    single { DatabaseDriverFactory(context = get()) }
    single { NotificationsManager(context = get()) }
}
