package com.joelkanyi.focusbloom.platform

import com.russhwolf.settings.Settings

expect class MultiplatformSettingsWrapper {
    fun createSettings(): Settings
}
