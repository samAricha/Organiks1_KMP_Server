package com.teka.organiks.android

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import com.teka.organiks.OrganiksApp

class  MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var hasCamPermission by remember {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    mutableStateOf(
                        ContextCompat.checkSelfPermission(
                            this,
                            android.Manifest.permission.POST_NOTIFICATIONS,
                        ) == PackageManager.PERMISSION_GRANTED,
                    )
                } else {
                    mutableStateOf(true)
                }
            }

            val notificationsPermissionLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.RequestPermission(),
                onResult = { granted ->
                    hasCamPermission = granted
                },
            )

            LaunchedEffect(key1 = true, block = {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    notificationsPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
                }
            })

            /*val notificationUtils = NotificationsManager(this)
            notificationUtils.showUpdateNotification(
                "Organiks",
                "Organiks is running in the background",
            )*/
            OrganiksApp()
        }
    }
}
