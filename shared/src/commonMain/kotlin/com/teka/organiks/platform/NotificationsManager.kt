package com.teka.organiks.platform

expect class NotificationsManager {
    fun showNotification(
        title: String,
        description: String,
    )
}
