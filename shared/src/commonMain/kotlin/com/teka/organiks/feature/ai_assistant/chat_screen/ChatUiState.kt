package com.teka.organiks.feature.ai_assistant.chat_screen

import com.teka.organiks.domain.model.ChatStatusModel
import com.teka.organiks.domain.model.ChatMessageModel


data class ChatUiState(
    val messages: List<ChatMessageModel> = emptyList(),
    val status: ChatStatusModel = ChatStatusModel.Idle,
    val apiKey: String = ""
)