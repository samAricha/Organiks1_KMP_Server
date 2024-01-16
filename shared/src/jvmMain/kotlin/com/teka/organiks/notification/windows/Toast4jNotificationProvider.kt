package com.teka.organiks.notification.windows

import com.teka.organiks.notification.NotificationProvider
import de.mobanisto.toast4j.ToastBuilder
import de.mobanisto.toast4j.ToastHandle
import de.mobanisto.toast4j.Toaster
import de.mobanisto.wintoast.WinToastTemplate

object Toast4jNotificationProvider : NotificationProvider {

    private lateinit var toaster: Toaster

    override var available: Boolean = false
        private set

    private enum class Error { NONE, INIT }

    private var error = Error.NONE

    override val errorMessage: String
        get() = ""

    override fun init() {
        toaster = Toaster.forAumi("com.joelkanyi.focusbloom")
        available = toaster.initialize()
        if (!available) {
            error = Error.INIT
            println("unable to initialize toast4j")
            return
        }
    }

    override fun uninit() {
        currentToast?.hide()
    }

    private var currentToast: ToastHandle? = null

    override fun sendNotification(title: String, description: String) {
        currentToast?.hide()
        currentToast = toaster.showToast(
            ToastBuilder(WinToastTemplate.WinToastTemplateType.ToastText01).setSilent()
                .setLine1(title)
                .setLine2(description)
                .build(),
        )
    }
}
