package com.teka.organiks.feature.ai_assistant.image_selection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ImageSearch
import androidx.compose.material.icons.rounded.ImageSearch
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teka.organiks.core.presentation.component.BloomButton
import com.teka.organiks.core.presentation.theme.PrimaryLightColor
import com.teka.organiks.core.presentation.theme.SecondaryLightColor
import com.mohamedrejeb.calf.io.readByteArray
import com.mohamedrejeb.calf.picker.FilePickerFileType
import com.mohamedrejeb.calf.picker.FilePickerSelectionMode
import com.mohamedrejeb.calf.picker.rememberFilePickerLauncher
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ImageSelectionScreen(){

    val geminiApi = remember { GeminiApi() }
    val coroutineScope = rememberCoroutineScope()

    val imageSelectionViewModel = remember { ImageSelectionScreenViewModel() }
    val geminiQuiz by imageSelectionViewModel.geminiQuiz.collectAsState()
    val pickedImage by imageSelectionViewModel.pickedImage.collectAsState()


    var content by remember { mutableStateOf("") }
    var showProgress by remember { mutableStateOf(false) }


    val pickerLauncher = rememberFilePickerLauncher(
        type = FilePickerFileType.Image,
        selectionMode = FilePickerSelectionMode.Single,
        onResult = { files ->
            files.firstOrNull()?.let { file ->
                imageSelectionViewModel.updatePickedImage(file.readByteArray())
            }
        }
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "AI Assistant",
                        fontSize = 20.sp
                    )},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = androidx.compose.material3.MaterialTheme.colorScheme.background,
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = androidx.compose.material3.MaterialTheme.colorScheme.primary,
                onClick = {
                    pickerLauncher.launch()
                },
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                ),
                shape = CircleShape,
            ) {
                Icon(
                    imageVector = Icons.Filled.ImageSearch,
                    contentDescription = "Add Image",
                    tint = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(24.dp),
                )
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            if(pickedImage == null) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(40))
                        .background(PrimaryLightColor)
                        .clickable {
                            pickerLauncher.launch()
                        }
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colors.onSecondary,
                            shape = RoundedCornerShape(40)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ImageSearch,
                        contentDescription = "Add photo",
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(40.dp),
                    )
                }
            } else {
                SelectedPhoto(
                    imageByteArray = pickedImage!!,
                    modifier = Modifier
                        .size(150.dp)
                        .clickable {
                            pickerLauncher.launch()
                        }
                )
            }


            OutlinedTextField(
                value = geminiQuiz,
                placeholder = { Text(text = "Upload Image and ask question")},
                onValueChange = {
                    imageSelectionViewModel.updateQuiz(it)
                },
                label = { Text(text = "Please type your question")},
                modifier = Modifier.fillMaxWidth(0.82f)

            )
            Spacer(modifier = Modifier.height(10.dp))

            BloomButton(
                content = { Text(text = "Search", color = Color.White) },
                backgroundColor = SecondaryLightColor,
                onClick = {
                    //here we place the actual implementation of calling Gemini api
                    if (geminiQuiz.isNotBlank() && pickedImage != null) {
                        coroutineScope.launch {
                            showProgress = true
                            val result = geminiApi.generateContentWithMedia(geminiQuiz, pickedImage!!)
                            println("our resp ----> ${result.getText()}")


                            if (result.error == null) {
                                content = result.getText().toString()
                            } else {
                                content = "No results"
                            }

                            showProgress = false
                        }
                    }

                },

            )

            Spacer(Modifier.height(16.dp))
            if (showProgress) {
                CircularProgressIndicator()
            } else {
                Box(
                    modifier = Modifier.fillMaxWidth().padding(5.dp)
                ){
                    Text(
                        text = content,
                        fontSize = 18.sp
                    )
                }

            }
        }

    }

}