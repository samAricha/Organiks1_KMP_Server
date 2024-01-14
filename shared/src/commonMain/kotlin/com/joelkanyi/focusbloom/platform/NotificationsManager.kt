package com.joelkanyi.focusbloom.platform

expect class NotificationsManager {
    fun showNotification(
        title: String,
        description: String,
    )
}
