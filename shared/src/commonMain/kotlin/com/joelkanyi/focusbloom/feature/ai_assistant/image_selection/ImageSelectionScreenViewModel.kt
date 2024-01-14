package com.joelkanyi.focusbloom.feature.ai_assistant.image_selection

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class ImageSelectionScreenViewModel: ScreenModel {


    private val _pickedImage = MutableStateFlow<ByteArray?>(null)
    val pickedImage = _pickedImage.asStateFlow()

    private val _geminiQuiz = MutableStateFlow("")
    val geminiQuiz = _geminiQuiz.asStateFlow()

    fun updateQuiz(quiz: String){
        _geminiQuiz.update {quiz }
    }

    fun updatePickedImage(img: ByteArray){
        _pickedImage.update {img }
    }


}