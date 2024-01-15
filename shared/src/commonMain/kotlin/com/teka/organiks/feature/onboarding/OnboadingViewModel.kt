package com.teka.organiks.feature.onboarding

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.teka.organiks.core.domain.repository.settings.SettingsRepository
import com.teka.organiks.core.utils.UiEvents
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class OnboadingViewModel(
    private val settingsRepository: SettingsRepository,
) : ScreenModel {


    private val _eventsFlow = Channel<UiEvents>(Channel.UNLIMITED)
    val eventsFlow = _eventsFlow.receiveAsFlow()

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()
    fun setUsername(username: String) {
        _username.value = username
    }

    fun saveUsername() {
        screenModelScope.launch {
            settingsRepository.saveUsername(username.value.trim())
            settingsRepository.toggleReminder(1)
            _eventsFlow.send(UiEvents.Navigation)
        }
    }

    val typeWriterTextParts = listOf(
        "be focused",
        "be present",
        "concentrate",
        "be effective",
        "be productive",
        "get things done",
        "be efficient",
        "be organized",
        "be intentional",
        "be disciplined",
        "be motivated",
        "be consistent",
        "be mindful",
    )
}
