package com.teka.organiks.ui.extension

import androidx.compose.material3.SnackbarHostState
import com.teka.organiks.domain.model.ChatStatus
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun SnackbarHostState.showSnackBar(scope: CoroutineScope, status: ChatStatus) {
    if (status is ChatStatus.Error) {
        scope.launch {
            showSnackbar(
                message = status.message,
                withDismissAction = true
            )
        }
    } else {
        this.currentSnackbarData?.dismiss()
    }
}