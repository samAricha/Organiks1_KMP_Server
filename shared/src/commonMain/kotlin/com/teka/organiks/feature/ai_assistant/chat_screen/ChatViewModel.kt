package com.teka.organiks.feature.ai_assistant.chat_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.teka.organiks.core.data.repository.gemini.GeminiRepositoryImpl
import com.teka.organiks.domain.model.ChatStatusModel
import com.teka.organiks.domain.model.MessageModel
import com.teka.organiks.domain.model.Sender
import com.teka.organiks.domain.repository.GeminiRepository
import kotlinx.coroutines.launch

class ChatViewModel : ScreenModel {

    private val geminiRepository: GeminiRepository = GeminiRepositoryImpl()

    private val _uiState = mutableStateOf(ChatUiState())
    val uiState: State<ChatUiState> = _uiState

    init {
        screenModelScope.launch {
            _uiState.value = _uiState.value.copy(apiKey = geminiRepository.getApiKey())
        }
    }

    fun setApiKey(key: String) {
        geminiRepository.setApiKey(key)
        _uiState.value = _uiState.value.copy(apiKey = key, status = ChatStatusModel.Success("API key updated successfully."))
    }

    fun generateContent(message: String, images: List<ByteArray> = emptyList()) {
        screenModelScope.launch {
            addToMessages(message, images, Sender.User)
            addToMessages("", emptyList(), Sender.Bot, true)

            when (val response = geminiRepository.generate(message, images)) {
                is ChatStatusModel.Success -> updateLastBotMessage(response.data, response)
                is ChatStatusModel.Error -> updateLastBotMessage(response.message, response)
                else -> {}
            }
        }
    }

    private fun updateLastBotMessage(text: String, status: ChatStatusModel) {
        val messages = _uiState.value.messages.toMutableList()
        if (messages.isNotEmpty() && messages.last().sender == Sender.Bot) {
            val last = messages.last()
            val updatedMessage = last.copy(text = text, isLoading = status == ChatStatusModel.Loading)
            messages[messages.lastIndex] = updatedMessage
            _uiState.value = _uiState.value.copy(
                messages = messages,
                status = status
            )
        }
    }

    private fun addToMessages(
        text: String,
        images: List<ByteArray>,
        sender: Sender,
        isLoading: Boolean = false
    ) {
        val message = MessageModel(sender, text, images, isLoading)
        _uiState.value = _uiState.value.copy(
            messages = _uiState.value.messages + message,
            status = if (isLoading) ChatStatusModel.Loading else ChatStatusModel.Idle
        )
    }
}