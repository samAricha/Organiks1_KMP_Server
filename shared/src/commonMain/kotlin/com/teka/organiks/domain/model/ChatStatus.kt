package com.teka.organiks.domain.model
sealed class ChatStatus {
    data object Idle : ChatStatus()
    class Success(val data: String) : ChatStatus()
    class Error(val message: String) : ChatStatus()
    data object Loading : ChatStatus()
}