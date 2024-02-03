package com.teka.organiks.feature.ai_assistant.chat_screen

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.teka.organiks.core.presentation.theme.AiLightGreen
import com.teka.organiks.core.presentation.theme.AiLightRed
import com.teka.organiks.core.presentation.theme.LightGreen
import com.teka.organiks.domain.model.ChatMessageModel
import com.teka.organiks.domain.model.ChatStatusModel
import com.teka.organiks.ui.extension.showSnackBar
import com.teka.organiks.ui.widgets.CustomAppBar
import com.teka.organiks.ui.widgets.CustomBottomSearchBar
import com.teka.organiks.ui.widgets.CustomDialog
import com.teka.organiks.ui.widgets.CustomSnackBar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun AssistantChatScreen(viewModel: ChatViewModel = ChatViewModel()) {
    val chatUiState = viewModel.uiState
    val focusManager = LocalFocusManager.current
    val coroutineScope = rememberCoroutineScope()
    val apiKeySnackBarHostState = remember { SnackbarHostState() }
    val errorSnackBarHostState = remember { SnackbarHostState() }
    val showDialog = remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            CustomAppBar(onActionClick = { showDialog.value = true })
        },
        bottomBar = {
            CustomBottomSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 30.dp, top = 5.dp),
                status = chatUiState.value.status,
                onSendClick = { text, images ->
                    coroutineScope.launch(Dispatchers.IO) {
                        viewModel.generateContent(text, images)
                    }
                },
            )
        },
        snackbarHost = {
            SnackbarHost(errorSnackBarHostState) { data ->
                CustomSnackBar(
                    data = data,
                    containerColor = AiLightRed
                )
            }
            SnackbarHost(apiKeySnackBarHostState) { data ->
                CustomSnackBar(
                    data = data,
                    containerColor = AiLightGreen
                )
            }
        },
        modifier = Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = { focusManager.clearFocus() })
        },
    ) { paddingValues ->
        ChatList(
            modifier = Modifier.padding(paddingValues),
            messages = chatUiState.value.messages
        )

        if (showDialog.value) {
            CustomDialog(
                value = chatUiState.value.apiKey,
                onVisibilityChanged = { showDialog.value = it },
                onSaveClicked = {
                    coroutineScope.launch {
                        viewModel.setApiKey(it)
                        apiKeySnackBarHostState.currentSnackbarData?.dismiss()
                        if(chatUiState.value.status is ChatStatusModel.Success){
                            apiKeySnackBarHostState.showSnackbar(
                                message = (chatUiState.value.status as ChatStatusModel.Success).data,
                                withDismissAction = true
                            )
                        }

                    }
                }
            )
        }

        errorSnackBarHostState.showSnackBar(coroutineScope, chatUiState.value.status)
    }
}


@Composable
fun ChatList(modifier: Modifier, messages: List<ChatMessageModel>) {
    val listState = rememberLazyListState()

    if (messages.isNotEmpty()) {
        LaunchedEffect(messages) {
            listState.animateScrollToItem(messages.lastIndex)
        }
    }
    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(messages.size) {
            val message = messages[it]
            if (message.images.isNotEmpty()) {
//                MessageImagesStack(message = message)
                Spacer(modifier = Modifier.height(4.dp))
            }
//            MessageBubble(message = message)
        }
    }
}